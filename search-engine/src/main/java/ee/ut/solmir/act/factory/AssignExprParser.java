package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.AssignmentACT;
import ee.ut.solmir.act.model.ExprACT;
import japa.parser.ast.expr.AssignExpr;

class AssignExprParser extends AbstractASTParser<AssignmentACT, AssignExpr> {
	AssignExprParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public AssignmentACT parse(AssignExpr node) {
		return new AssignmentACT(node, (ExprACT) createACTInternal(node.getTarget()), (ExprACT) createACTInternal(node.getValue()));
	}
}