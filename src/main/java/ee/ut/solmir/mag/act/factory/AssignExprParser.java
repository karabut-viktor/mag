package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.expr.AssignExpr;
import ee.ut.solmir.mag.act.model.AssignmentACT;
import ee.ut.solmir.mag.act.model.ExprACT;

class AssignExprParser extends AbstractASTParser<AssignmentACT, AssignExpr> {
	AssignExprParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public AssignmentACT parse(AssignExpr node) {
		return new AssignmentACT(node, (ExprACT) createACTInternal(node.getTarget()), (ExprACT) createACTInternal(node.getValue()));
	}
}