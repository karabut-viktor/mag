package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.body.VariableDeclarator;
import ee.ut.solmir.mag.act.model.AssignmentACT;
import ee.ut.solmir.mag.act.model.ExprACT;
import ee.ut.solmir.mag.act.model.VarACT;

class VariableDeclaratorParser extends AbstractASTParser<AssignmentACT, VariableDeclarator> {
	VariableDeclaratorParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public AssignmentACT parse(VariableDeclarator node) {
    return new AssignmentACT(node, new VarACT(node, node.getId().getName()), (ExprACT) createACTInternal(node.getInit()));
  }
}