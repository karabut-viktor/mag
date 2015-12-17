package ee.ut.solmir.act.model;

import japa.parser.ast.Node;

public abstract class ACT {
	private final static int INTENT_SIZE = 2;
	
	private final Node astNode;
	private boolean hashcodeInitialized;
	private int hashcode;
	
	public ACT(Node astNode) {
		this.astNode = astNode;
	}

	public Node getAstNode() {
	  return astNode;
  }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	  prettyString(sb, 0);
	  return sb.toString();
	}
	
	protected void prettyString(StringBuilder sb, int intentLevel) {
		intent(sb, intentLevel);
		sb.append(super.toString());
	}
	
	protected void intent(StringBuilder sb, int intentLevel) {
		for (int i = 0; i < intentLevel*INTENT_SIZE; i++) {
			sb.append(' ');
    }
	}
	
	@Override
	public int hashCode() {
	  if (!hashcodeInitialized) {
	  	hashcode = hashCodeInternal();
	  	hashcodeInitialized = true;
	  }
	  return hashcode;
	}

	abstract protected int hashCodeInternal();
	
	abstract public double similarity(ACT o);
}
