package ee.ut.solmir.mag.act.factory;

import japa.parser.ast.stmt.WhileStmt;
import ee.ut.solmir.mag.act.model.ExprACT;
import ee.ut.solmir.mag.act.model.WhileACT;

class WhileStmtParser extends AbstractASTParser<WhileACT,  WhileStmt> {
	WhileStmtParser(ACTFactory actFactory) {
	  super(actFactory);
  }

	public WhileACT parse(WhileStmt node) {
		return new WhileACT(node, (ExprACT) this.actFactory.createACTInternal(node.getCondition()), this.actFactory.promoteToBlock(this.actFactory.createACTInternal(node.getBody())));
	}
}