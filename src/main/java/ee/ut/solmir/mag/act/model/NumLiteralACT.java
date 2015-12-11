package ee.ut.solmir.mag.act.model;

import japa.parser.ast.Node;

public class NumLiteralACT extends ExprACT {
	private final static double DELTA = 0.01;
	private final double value;

	public NumLiteralACT(Node astNode, double value) {
	  super(astNode);
	  this.value = value;
  }

	@Override
  protected int hashCodeInternal() {
	  // TODO Auto-generated method stub
	  return 0;
  }

	@Override
	protected void prettyString(StringBuilder sb, int intentLevel) {
	  sb.append(String.valueOf(value));
	}
	
	@Override
  public double similarity(ACT o) {
		if (o instanceof NumLiteralACT) {
			NumLiteralACT num = (NumLiteralACT) o;
			if (Math.abs(value - num.value) <= DELTA) {
				return 1;
			}
			else {
				return 0.5;
			}
		}
	  return 0;
  }
	
}
