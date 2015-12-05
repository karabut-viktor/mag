package ee.ut.solmir.mag;

import japa.parser.ast.body.MethodDeclaration;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ee.ut.solmir.mag.act.ACTFactory;
import ee.ut.solmir.mag.act.ParserUtils;
import ee.ut.solmir.mag.act.model.ACT;
import ee.ut.solmir.mag.act.model.MethodACT;

public class App {

	public static void main(String[] args) throws Exception {
//		showMethods("test_samples/StringUtils.java");
//		showMethods("test_samples/EasySample.java");
//		showMethods("test_samples/HashCodeTest.java");
		
//		findSameHashCode("test_samples/HashCodeTest.java");
//		findSameHashCode("test_samples/StringUtils.java");
		
		compare2Methods("test_samples/VariableRename.java", "a", "b");
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
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
	    type type = (type) iterator.next();
	    
    }
		System.out.println();
		System.out.println(m1);
		System.out.println();
		System.out.println(m2);
	}
	
	private static void findSameHashCode(String fileName) {
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
