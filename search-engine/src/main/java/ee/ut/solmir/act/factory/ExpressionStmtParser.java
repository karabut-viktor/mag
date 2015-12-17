package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.ACT;
import japa.parser.ast.stmt.ExpressionStmt;

class ExpressionStmtParser extends AbstractASTParser<ACT, ExpressionStmt> {
	ExpressionStmtParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public ACT parse(ExpressionStmt node) {
    return createACTInternal(node.getExpression());
  }
}