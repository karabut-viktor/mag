package ee.ut.solmir.act.model;

import japa.parser.ast.Node;

import java.util.Objects;

public class AssignmentACT extends ExprACT {
	private final ExprACT lvalue;
	private final ExprACT rvalue;

	public AssignmentACT(Node astNode, ExprACT lvalue, ExprACT rvalue) {
	  super(astNode);
	  this.lvalue = lvalue;
	  this.rvalue = rvalue;
  }

	public ExprACT getLValue() {
	  return lvalue;
  }

	public ExprACT getRValue() {
	  return rvalue;
  }
	
	@Override
	protected void prettyString(StringBuilder sb, int intentLevel) {
		sb.append(lvalue).append(" = ");
		rvalue.prettyString(sb, intentLevel);
	}
	
	@Override
	protected int hashCodeInternal() {
	  return Objects.hash(71, rvalue);
	}
	
	@Override
  public double similarity(ACT o) {
	  if (AssignmentACT.class.equals(o.getClass())) {
	  	AssignmentACT mo = (AssignmentACT)o;
	  	return 0.1 + 0.4 * lvalue.similarity(mo.lvalue) + 0.5 * rvalue.similarity(mo.rvalue);
	  }
	  return 0;
  }
}
