package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.expr.IntegerLiteralExpr;
import ee.ut.solmir.mag.act.model.NumLiteralACT;

public class IntegerLiteralExprParser extends AbstractASTParser<NumLiteralACT, IntegerLiteralExpr> {

	IntegerLiteralExprParser(ACTFactory actFactory) {
	  super(actFactory);
  }

	public NumLiteralACT parse(IntegerLiteralExpr node) {
	  return new NumLiteralACT(node, Double.parseDouble(node.getValue()));
  }

}
