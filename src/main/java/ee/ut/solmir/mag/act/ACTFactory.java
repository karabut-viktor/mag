package ee.ut.solmir.mag.act;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ee.ut.solmir.mag.act.model.*;
import japa.parser.ast.Node;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.AssignExpr;
import japa.parser.ast.expr.MethodCallExpr;
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
		parsers.put(MethodDeclaration.class, new MethodDeclarationParser());
		parsers.put(BlockStmt.class, new BlockStmtParser());
		parsers.put(ExpressionStmt.class, new ExpressionStmtParser());
		parsers.put(VariableDeclarationExpr.class, new VariableDeclarationExprParser());
		parsers.put(VariableDeclarator.class, new VariableDeclaratorParser());
		parsers.put(ReturnStmt.class, new ReturnStmtParser());
		parsers.put(AssignExpr.class, new AssignExprParser());
		parsers.put(MethodCallExpr.class, new MethodCallExprParser());
		parsers.put(IfStmt.class, new IfStmtParser());
		parsers.put(WhileStmt.class, new WhileStmtParser());
	}
	
	private interface ASTParser<T1 extends ACT, T2 extends Node> {
		T1 parse(T2 node);
	}
	
	private class MethodDeclarationParser implements ASTParser<MethodACT, MethodDeclaration> {
		public MethodACT parse(MethodDeclaration node) {
			String name = node.getName();
			BlockACT body = (BlockACT) createACTInternal(node.getBody());
	    return new MethodACT(node, name, body);
    }
	}
	
	private class BlockStmtParser implements ASTParser<BlockACT, BlockStmt> {
		public BlockACT parse(BlockStmt node) {
			ArrayList<ACT> children = new ArrayList<ACT>();
	    for (Node child : node.getChildrenNodes()) {
	    	ACT act = createACTInternal(child);
	    	if (act instanceof BlockACT) {
	    		children.addAll(((BlockACT)act).getChildren());
	    	}
	    	else {
	    		children.add(act);
	    	}
	    }
	    return new BlockACT(node, children);
    }
	}
	
	private class ExpressionStmtParser implements ASTParser<ACT, ExpressionStmt> {
		public ACT parse(ExpressionStmt node) {
	    return createACTInternal(node.getExpression());
    }
	}
	
	private class VariableDeclarationExprParser implements ASTParser<ACT, VariableDeclarationExpr> {

		public ACT parse(VariableDeclarationExpr node) {
	    return new BlockACT(node, createAllACTInternal(node.getVars()));
    }
	}
	
	private class VariableDeclaratorParser implements ASTParser<AssignmentACT, VariableDeclarator> {
		public AssignmentACT parse(VariableDeclarator node) {
	    return new AssignmentACT(node, node.getId().getName(), (ExprACT) createACTInternal(node.getInit()));
    }
	}
	
	private class ReturnStmtParser implements ASTParser<ReturnACT, ReturnStmt> {
		public ReturnACT parse(ReturnStmt node) {
			return new ReturnACT(node, (ExprACT) createACTInternal(node.getExpr()));
		}
	}
	
	private class AssignExprParser implements ASTParser<AssignmentACT, AssignExpr> {
		public AssignmentACT parse(AssignExpr node) {
			return new AssignmentACT(node, node.getTarget().toString(), (ExprACT) createACTInternal(node.getValue()));
		}
	}
	
	private class MethodCallExprParser implements ASTParser< MethodCallACT,  MethodCallExpr> {
		public MethodCallACT parse(MethodCallExpr node) {
			List<ExprACT> argsACTs = createAllACTInternal(node.getArgs());
	    return new MethodCallACT(node, node.getScope() == null ? "this" : node.getScope().toString(), node.getName(), argsACTs);
    }
	}
	
	private class IfStmtParser implements ASTParser<IfACT,  IfStmt> {
		public IfACT parse(IfStmt node) {
	    return new IfACT(node, (ExprACT) createACTInternal(node.getCondition()), promoteToBlock(createACTInternal(node.getThenStmt())),  promoteToBlock(createACTInternal(node.getElseStmt())));
    }
	}
	private class WhileStmtParser implements ASTParser<WhileACT,  WhileStmt> {
		public WhileACT parse(WhileStmt node) {
			return new WhileACT(node, (ExprACT) createACTInternal(node.getCondition()), promoteToBlock(createACTInternal(node.getBody())));
		}
	}
	
	private ACTFactory() {}
	
	public MethodACT createACT(MethodDeclaration md) {
		MethodACT methodACT= (MethodACT) createACTInternal(md);
		return methodACT;
	}
	
	@SuppressWarnings("unchecked")
  private ACT createACTInternal(Node node) {
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
  private <T extends ACT> List<T> createAllACTInternal(List<? extends Node> nodes) {
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
	
	private BlockACT promoteToBlock(ACT act) {
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
