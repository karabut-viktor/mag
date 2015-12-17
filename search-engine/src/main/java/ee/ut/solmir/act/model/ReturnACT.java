package ee.ut.solmir.act.model;

import japa.parser.ast.Node;

import java.util.Objects;

public class ReturnACT extends ACT {
	private final ExprACT expr;

	public ReturnACT(Node astNode, ExprACT expr) {
	  super(astNode);
	  this.expr = expr;
  }

	public ExprACT getExpr() {
	  return expr;
  }
	
	@Override
	protected void prettyString(StringBuilder sb, int intentLevel) {
		sb.append("return ");
		expr.prettyString(sb, intentLevel);
		sb.append(";");
	}

	@Override
  protected int hashCodeInternal() {
		 return Objects.hash(43, expr);
  }
	
	@Override
  public double similarity(ACT o) {
	  if (ReturnACT.class.equals(o.getClass())) {
	  	ReturnACT mo = (ReturnACT)o;
	  	return 0.2 + 0.8 * expr.similarity(mo.expr);
	  }
	  return 0;
  }
}
