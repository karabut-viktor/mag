package ee.ut.solmir.act.factory;

import japa.parser.ast.Node;
import japa.parser.ast.stmt.BlockStmt;

import java.util.ArrayList;

import ee.ut.solmir.act.model.ACT;
import ee.ut.solmir.act.model.BlockACT;

class BlockStmtParser extends AbstractASTParser<BlockACT, BlockStmt> {
	BlockStmtParser(ACTFactory actFactory) {
    super(actFactory);
  }

	public BlockACT parse(BlockStmt node) {
		ArrayList<ACT> children = new ArrayList<ACT>();
    for (Node child : node.getChildrenNodes()) {
    	ACT act = createACTInternal(child);
    	if (act instanceof BlockACT) {
    		children.addAll(((BlockACT)act).getChildren());
    	}
    	else {
    		children.add(act);
    	}
    }
    return new BlockACT(node, children);
  }
}