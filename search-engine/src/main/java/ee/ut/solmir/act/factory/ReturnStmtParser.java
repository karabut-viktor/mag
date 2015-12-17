package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.ExprACT;
import ee.ut.solmir.act.model.ReturnACT;
import japa.parser.ast.stmt.ReturnStmt;

class ReturnStmtParser extends AbstractASTParser<ReturnACT, ReturnStmt> {
	ReturnStmtParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public ReturnACT parse(ReturnStmt node) {
		return new ReturnACT(node, (ExprACT) createACTInternal(node.getExpr()));
	}
}