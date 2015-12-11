package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.expr.NameExpr;
import ee.ut.solmir.mag.act.model.VarACT;

public class NameExprParser extends AbstractASTParser<VarACT, NameExpr> {
	NameExprParser(ACTFactory actFactory) {
	  super(actFactory);
  }

	public VarACT parse(NameExpr node) {
	  return new VarACT(node, node.toString());
  }
}
