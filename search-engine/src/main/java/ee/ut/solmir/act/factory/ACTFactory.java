package ee.ut.solmir.act.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ee.ut.solmir.act.model.*;
import japa.parser.ast.Node;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.AssignExpr;
import japa.parser.ast.expr.BinaryExpr;
import japa.parser.ast.expr.IntegerLiteralExpr;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.IfStmt;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.stmt.WhileStmt;

public class ACTFactory {
	public static final ACTFactory INSTANCE = new ACTFactory();
	
	@SuppressWarnings("rawtypes")
  private final Map<Class, ASTParser> parsers = new HashMap<Class, ASTParser>();
	{
		registerParser(MethodDeclaration.class, new MethodDeclarationParser(this));
		registerParser(BlockStmt.class, new BlockStmtParser(this));
		registerParser(ExpressionStmt.class, new ExpressionStmtParser(this));
		registerParser(VariableDeclarationExpr.class, new VariableDeclarationExprParser(this));
		registerParser(MethodDeclaration.class, new MethodDeclarationParser(this));
		registerParser(VariableDeclarator.class, new VariableDeclaratorParser(this));
		registerParser(ReturnStmt.class, new ReturnStmtParser(this));
		registerParser(AssignExpr.class, new AssignExprParser(this));
		registerParser(MethodCallExpr.class, new MethodCallExprParser(this));
		registerParser(IfStmt.class, new IfStmtParser(this));
		registerParser(WhileStmt.class, new WhileStmtParser(this));
		registerParser(BinaryExpr.class, new BinaryExprParser(this));
		registerParser(NameExpr.class, new NameExprParser(this));
		registerParser(IntegerLiteralExpr.class, new IntegerLiteralExprParser(this));
	}
	
	private <T extends Node> void registerParser(Class<T> klass, ASTParser<? extends ACT, T> parser) {
		parsers.put(klass, parser);
	}
	
	public MethodACT createACT(MethodDeclaration md) {
		MethodACT methodACT= (MethodACT) createACTInternal(md);
		return methodACT;
	}
	
	@SuppressWarnings("unchecked") ACT createACTInternal(Node node) {
		ACT act;
		if (node == null) {
			act = new NullACT(null);
		} 
		else {
		
  		ASTParser<ACT, Node> builder = parsers.get(node.getClass());
  		if (builder != null) {
  			act = builder.parse(node);
  		}
  		else {
  			act = new UnrecognizedACT(node);
  		}
		}
//		System.out.println("Created ACT " + act.getClass().getSimpleName() + "  hash code = " + act.hashCode());
		return act;
	}
	
	@SuppressWarnings("unchecked")
  <T extends ACT> List<T> createAllACTInternal(List<? extends Node> nodes) {
		if (nodes == null) {
			return Collections.emptyList();
		}
		
		ArrayList<ACT> acts = new ArrayList<ACT>();
    for (Node child : nodes) {
    	ACT act = createACTInternal(child);
  		acts.add(act);
    }
    return (List<T>) acts;
	}
	
	BlockACT promoteToBlock(ACT act) {
		if (act instanceof BlockACT) {
			return (BlockACT) act;
		}
		else if (act instanceof NullACT) {
			return new BlockACT(null, Collections.<ACT>emptyList());
		}
		else {
			return new BlockACT(act.getAstNode(), Collections.singletonList(act));
		}
	}	
}
