package ee.ut.solmir.act;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.Node;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class ParserUtils {
  private ParserUtils() {
  }

  public static Map<String, MethodDeclaration> parseMethodsAsMap(File javaSource) {
    try {
      FileInputStream in = new FileInputStream(javaSource);
      CompilationUnit cu;
      try {
        // parse the file
        cu = JavaParser.parse(in);
      }
      finally {
        in.close();
      }
      ClassOrInterfaceDeclaration classOrInterface = null;
      for (Node node : cu.getChildrenNodes()) {
        if (node instanceof ClassOrInterfaceDeclaration) {
          classOrInterface = (ClassOrInterfaceDeclaration) node;
        }
      }

      Map<String, MethodDeclaration> methods = new TreeMap<String, MethodDeclaration>();
      for (Node node : classOrInterface.getChildrenNodes()) {
        if (node instanceof MethodDeclaration) {
          MethodDeclaration md = (MethodDeclaration) node;
          methods.put(md.getName(), md);
        }
      }

      return methods;
    }
    catch (Exception e) {
      e.printStackTrace();
      return Collections.emptyMap();
    }
  }

  public static List<MethodDeclaration> parseMethods(File javaSource) throws FileNotFoundException, IOException, ParseException {
    try (FileInputStream fin = new FileInputStream(javaSource)) {
      return parseMethods(fin);
    }
  }
  
  public static List<MethodDeclaration> parseMethods(InputStream in) throws ParseException {
    CompilationUnit cu;
    cu = JavaParser.parse(in);
    ClassOrInterfaceDeclaration classOrInterface = null;
    for (Node node : cu.getChildrenNodes()) {
      if (node instanceof ClassOrInterfaceDeclaration) {
        classOrInterface = (ClassOrInterfaceDeclaration) node;
      }
    }

    List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
    for (Node node : classOrInterface.getChildrenNodes()) {
      if (node instanceof MethodDeclaration) {
        MethodDeclaration md = (MethodDeclaration) node;
        methods.add(md);
      }
    }

    return methods;
  }
}
