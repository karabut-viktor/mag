package ee.ut.solmir.act;

import japa.parser.ast.body.MethodDeclaration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import ee.ut.solmir.act.factory.ACTFactory;
import ee.ut.solmir.act.model.ACT;
import ee.ut.solmir.act.model.MethodACT;

public class App {
  public static class SimHolder {
    public final MethodACT m1;
    public final MethodACT m2;
    public final double similarity;

    public SimHolder(MethodACT m1, MethodACT m2, double similarity) {
      this.m1 = m1;
      this.m2 = m2;
      this.similarity = similarity;
    }
  }
  public static void main(String[] args) throws Exception {
    String method = 
          "        int strLen;"
        + "        if (str == null || (strLen = str.length()) == 0) {"
        + "            return true;"
        + "        }"
        + "        for (int i = 0; i < strLen; i++) {"
        + "            if ((Character.isWhitespace(str.charAt(i)) == false)) {"
        + "                return false;"
        + "            }"
        + "        }"
        + "        return true;";
    System.out.println(new SearchEngine().findMostSimilarMethod(method));
    
    // showMethods("test_samples/StringUtils.java");
    // showMethods("test_samples/EasySample.java");
    // showMethods("test_samples/HashCodeTest.java");

    // findSameHashCode("test_samples/HashCodeTest.java");
    // findSameHashCode("test_samples/StringUtils.java");

    //mostSimilarMethdos("test_samples/StringUtils.java");

    // compare2Methods("test_samples/VariableRename.java", "a", "b");
    // compare2Methods("test_samples/LogMethodTest.java", "a", "b");
    // compare2Methods("test_samples/LogBeforeReturn.java", "a", "b");
    // compare2Methods("test_samples/WhileVsFor.java", "a", "b");
    // compare2Methods("test_samples/TryBlock.java", "a", "b");
    // compare2Methods("test_samples/SyncBlock.java", "a", "b");
    // compare2Methods("test_samples/InitListOrder.java", "a", "b");
    // compare2Methods("test_samples/VariableExtract.java", "a", "b");
  }

  private static void mostSimilarMethdos(String fileName) throws Exception {
    List<MethodACT> methods = new ArrayList<MethodACT>();
    for (MethodDeclaration md : ParserUtils.parseMethods(new File(fileName))) {
      methods.add(ACTFactory.INSTANCE.createACT(md));
    }
    
    List<App.SimHolder> holders = new ArrayList<App.SimHolder>();
    for (int i = 0; i < methods.size() - 1; i++) {
      for (int j = i + 1; j < methods.size(); j++) {
        MethodACT m1 = methods.get(i);
        MethodACT m2 = methods.get(j);
        double sim = m1.similarity(m2);
        if (sim != 1.0) {
          holders.add(new App.SimHolder(m1, m2, m1.similarity(m2)));
        }
      }
    }
    
    Collections.sort(holders, new Comparator<App.SimHolder>() {
      public int compare(App.SimHolder o1, App.SimHolder o2) {
        return -Double.compare(o1.similarity, o2.similarity);
      }
    });
    for (int i = 0; i < Math.min(30, holders.size()); i++) {
      App.SimHolder holder = holders.get(i);
      System.out.println(String.format("%s and %s similarity: %s", holder.m1.getName(), holder.m2.getName(), holder.similarity));
    }
  }

  private static void compare2Methods(String fileName, String m1name, String m2name) {
    Map<String, MethodDeclaration> methods = ParserUtils.parseMethodsAsMap(new File(fileName));

    MethodACT m1 = ACTFactory.INSTANCE.createACT(methods.get(m1name));
    MethodACT m2 = ACTFactory.INSTANCE.createACT(methods.get(m2name));
    if (m1.hashCode() == m2.hashCode()) {
      System.out.println(String.format("Methods %s and %s have same hashcode %d (similarity: %.3f)", m1.getName(), m2.getName(), m1.hashCode(), m1.similarity(m2)));
    }
    else {
      System.out.println(String.format("Methods %s and %s similarity: %.3f", m1.getName(), m2.getName(), m1.similarity(m2)));
    }
    System.out.println();
    System.out.println(m1);
    System.out.println();
    System.out.println(m2);
  }

  private static void findSameHashCode(String fileName) throws Exception {
    List<MethodACT> methods = new ArrayList<MethodACT>();
    for (MethodDeclaration md : ParserUtils.parseMethods(new File(fileName))) {
      methods.add(ACTFactory.INSTANCE.createACT(md));
    }

    for (int i = 0; i < methods.size() - 1; i++) {
      for (int j = i + 1; j < methods.size(); j++) {
        MethodACT m1 = methods.get(i);
        MethodACT m2 = methods.get(j);
        if (m1.hashCode() == m2.hashCode()) {
          System.out.println(String.format("Methods %s and %s have same hashcode %d (similarity: %.3f)", m1.getName(), m2.getName(), m1.hashCode(), m1.similarity(m2)));
          System.out.println();
          System.out.println(m1);
          System.out.println();
          System.out.println(m2);
        }
      }
    }
  }

  private static void showMethods(String fileName) {
    Map<String, MethodDeclaration> methods = ParserUtils.parseMethodsAsMap(new File(fileName));
    System.out.println(String.format("Parsed %d methods.\n", methods.size()));
    for (Map.Entry<String, MethodDeclaration> e : methods.entrySet()) {
      MethodDeclaration md = e.getValue();
      ACT act = ACTFactory.INSTANCE.createACT(md);
      System.out.println("Hash code:" + act.hashCode());
      System.out.println(act);
      System.out.println();
    }
  }
}
