package ee.ut.solmir.act.model;

import japa.parser.ast.Node;

public class UnrecognizedACT extends ExprACT {

	public UnrecognizedACT(Node astNode) {
	  super(astNode);
  }
	
	@Override
	protected void prettyString(StringBuilder sb, int intentLevel) {
	  sb.append("someUsefulStuff()");
	}

	@Override
  protected int hashCodeInternal() {
	  return 123;
  }

	@Override
  public double similarity(ACT o) {
	  return UnrecognizedACT.class.equals(o.getClass())? 1d : 0d;
  }
}
