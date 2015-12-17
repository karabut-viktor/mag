package ee.ut.solmir.act;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ee.ut.solmir.act.factory.ACTFactory;
import ee.ut.solmir.act.model.MethodACT;
import japa.parser.ast.body.MethodDeclaration;

public class SearchEngine {
  public static class SimHolder {
    public final MethodACT m1;
    public final MethodACT m2;
    public final double similarity;
    
    public double getSimilarity() {
      return similarity;
    }
    
    public MethodACT getM1() {
      return m1;
    }

    public MethodACT getM2() {
      return m2;
    }

    public SimHolder(MethodACT m1, MethodACT m2, double similarity) {
      this.m1 = m1;
      this.m2 = m2;
      this.similarity = similarity;
    }
    
    @Override
    public String toString() {
      return String.format("[m1=%s, m2=%s, sim=%f]", m1, m2, similarity);
    }
  }
  
  private final List<MethodACT> database = new ArrayList<>();
  
  public SearchEngine() {
    parseResource("/samples/StringUtils.java");
  }
  
  private void parseResource(String res) {
    try (InputStream is = this.getClass().getResourceAsStream(res)) {
      for (MethodDeclaration md : ParserUtils.parseMethods(is)) {
        database.add(ACTFactory.INSTANCE.createACT(md));
      }
    }
    catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public List<SimHolder> findMostSimilarMethod(String codeSnippet) {
    try {
      codeSnippet = "public class TestClass { public void testMethod() { " + codeSnippet  + " }  }";
      InputStream in;
        in = new ByteArrayInputStream(codeSnippet.getBytes("UTF8"));
      MethodACT method = null;
      for (MethodDeclaration md : ParserUtils.parseMethods(in)) {
        method = ACTFactory.INSTANCE.createACT(md);
      }
      return findMostSimilarMethdos(method);
    }
    catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return Collections.emptyList();
    }
  }
  
  private List<SimHolder> findMostSimilarMethdos(MethodACT method) throws FileNotFoundException, IOException {
    List<SimHolder> holders = new ArrayList<SimHolder>();
    for (MethodACT dbMethod : database) {
        double sim = method.similarity(dbMethod);
        holders.add(new SimHolder(method, dbMethod, sim));
    }
    
    Collections.sort(holders, new Comparator<SimHolder>() {
      public int compare(SimHolder o1, SimHolder o2) {
        return -Double.compare(o1.similarity, o2.similarity);
      }
    });
    
    List<SimHolder> result = new ArrayList<>();
    for (int i = 0; i < Math.min(10, holders.size()); i++) {
      SimHolder holder = holders.get(i);
      result.add(holder);
    }
    
    return holders;
  }
}
