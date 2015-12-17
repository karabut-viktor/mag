package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.NumLiteralACT;
import japa.parser.ast.expr.IntegerLiteralExpr;

public class IntegerLiteralExprParser extends AbstractASTParser<NumLiteralACT, IntegerLiteralExpr> {

	IntegerLiteralExprParser(ACTFactory actFactory) {
	  super(actFactory);
  }

	public NumLiteralACT parse(IntegerLiteralExpr node) {
	  return new NumLiteralACT(node, Double.parseDouble(node.getValue()));
  }

}
