package ee.ut.solmir.act.factory;

import ee.ut.solmir.act.model.BlockACT;
import ee.ut.solmir.act.model.ExprACT;
import ee.ut.solmir.act.model.IfACT;
import japa.parser.ast.stmt.IfStmt;

class IfStmtParser extends AbstractASTParser<IfACT,  IfStmt> {
	IfStmtParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public IfACT parse(IfStmt node) {
		ExprACT cond =  (ExprACT) actFactory.createACTInternal(node.getCondition());
		BlockACT thenBlock = promoteToBlock(createACTInternal(node.getThenStmt()));
		BlockACT elseBlock = promoteToBlock(createACTInternal(node.getElseStmt()));
		
    return new IfACT(node, cond, thenBlock,  elseBlock);
  }
}