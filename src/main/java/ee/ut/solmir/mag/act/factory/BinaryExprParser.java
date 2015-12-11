package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.expr.BinaryExpr;
import ee.ut.solmir.mag.act.model.ExprACT;
import ee.ut.solmir.mag.act.model.MethodCallACT;

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
