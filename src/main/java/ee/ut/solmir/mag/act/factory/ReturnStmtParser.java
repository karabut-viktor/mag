package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.stmt.ReturnStmt;
import ee.ut.solmir.mag.act.model.ExprACT;
import ee.ut.solmir.mag.act.model.ReturnACT;

class ReturnStmtParser extends AbstractASTParser<ReturnACT, ReturnStmt> {
	ReturnStmtParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public ReturnACT parse(ReturnStmt node) {
		return new ReturnACT(node, (ExprACT) createACTInternal(node.getExpr()));
	}
}