package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.stmt.ExpressionStmt;
import ee.ut.solmir.mag.act.model.ACT;

class ExpressionStmtParser extends AbstractASTParser<ACT, ExpressionStmt> {
	ExpressionStmtParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public ACT parse(ExpressionStmt node) {
    return createACTInternal(node.getExpression());
  }
}