package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.ExprACT;
import ee.ut.solmir.act.model.WhileACT;
import japa.parser.ast.stmt.WhileStmt;

class WhileStmtParser extends AbstractASTParser<WhileACT,  WhileStmt> {
	WhileStmtParser(ACTFactory actFactory) {
	  super(actFactory);
  }

	public WhileACT parse(WhileStmt node) {
		return new WhileACT(node, (ExprACT) this.actFactory.createACTInternal(node.getCondition()), this.actFactory.promoteToBlock(this.actFactory.createACTInternal(node.getBody())));
	}
}