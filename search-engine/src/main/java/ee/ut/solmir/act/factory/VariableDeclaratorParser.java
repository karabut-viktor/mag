package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.AssignmentACT;
import ee.ut.solmir.act.model.ExprACT;
import ee.ut.solmir.act.model.VarACT;
import japa.parser.ast.body.VariableDeclarator;

class VariableDeclaratorParser extends AbstractASTParser<AssignmentACT, VariableDeclarator> {
	VariableDeclaratorParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public AssignmentACT parse(VariableDeclarator node) {
    return new AssignmentACT(node, new VarACT(node, node.getId().getName()), (ExprACT) createACTInternal(node.getInit()));
  }
}