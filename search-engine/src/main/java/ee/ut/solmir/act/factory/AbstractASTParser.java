package ee.ut.solmir.act.factory;

import java.util.List;

import ee.ut.solmir.act.model.ACT;
import ee.ut.solmir.act.model.BlockACT;
import japa.parser.ast.Node;

public abstract class AbstractASTParser<T1 extends ACT, T2 extends Node> implements ASTParser<T1, T2>{
  protected final ACTFactory actFactory;

  AbstractASTParser(ACTFactory actFactory) {
    this.actFactory = actFactory;
  }
  
	protected ACT createACTInternal(Node node) {
		return actFactory.createACTInternal(node);
	}
	
	protected	BlockACT promoteToBlock(ACT act) {
		return actFactory.promoteToBlock(act);
	}
	
  protected <T extends ACT> List<T> createAllACTInternal(List<? extends Node> nodes) {
		return actFactory.createAllACTInternal(nodes);
	}
}
