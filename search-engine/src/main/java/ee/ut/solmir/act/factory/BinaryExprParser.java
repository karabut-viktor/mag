package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.ExprACT;
import ee.ut.solmir.act.model.MethodCallACT;
import japa.parser.ast.expr.BinaryExpr;

public class BinaryExprParser extends AbstractASTParser<MethodCallACT, BinaryExpr> {
	
	BinaryExprParser(ACTFactory actFactory) {
	  super(actFactory);
  }
	
	public MethodCallACT parse(BinaryExpr node) {
		ExprACT left = (ExprACT) createACTInternal(node.getLeft());
		ExprACT right = (ExprACT) createACTInternal(node.getRight());
		return new MethodCallACT(node, null, node.getOperator().toString(), left, right);
  }
}
