package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.VarACT;
import japa.parser.ast.expr.NameExpr;

public class NameExprParser extends AbstractASTParser<VarACT, NameExpr> {
	NameExprParser(ACTFactory actFactory) {
	  super(actFactory);
  }

	public VarACT parse(NameExpr node) {
	  return new VarACT(node, node.toString());
  }
}
