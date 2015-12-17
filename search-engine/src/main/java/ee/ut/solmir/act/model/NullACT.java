package ee.ut.solmir.act.model;

import japa.parser.ast.Node;

public class NullACT extends ExprACT {

	public NullACT(Node astNode) {
	  super(astNode);
  }
	
	@Override
	protected void prettyString(StringBuilder sb, int intentLevel) {
		sb.append("null");
	}
	
	@Override
	protected int hashCodeInternal() {
	  return 43; // just meaningless prime number
	}

	@Override
  public double similarity(ACT o) {
	  return NullACT.class.equals(o.getClass())? 1d : 0d;
  }
	
}
