package ee.ut.solmir.mag.act.model;

import japa.parser.ast.Node;

import java.util.Objects;

import ee.ut.solmir.mag.act.SimilarityUtils;

public class AssignmentACT extends ExprACT {
	private final String varName;
	private final ExprACT expr;

	public AssignmentACT(Node astNode, String varName, ExprACT expr) {
	  super(astNode);
	  this.varName = varName;
	  this.expr = expr;
  }

	public String getVarName() {
	  return varName;
  }

	public ExprACT getExpr() {
	  return expr;
  }
	
	@Override
	protected void prettyString(StringBuilder sb, int intentLevel) {
		sb.append(varName).append(" = ");
		expr.prettyString(sb, intentLevel);
	}
	
	@Override
	protected int hashCodeInternal() {
	  return Objects.hash(71, expr);
	}
	
	@Override
  public double similarity(ACT o) {
	  if (AssignmentACT.class.equals(o.getClass())) {
	  	AssignmentACT mo = (AssignmentACT)o;
	  	return 0.1 + 0.4 * SimilarityUtils.stringSimilarity(varName, mo.varName) + 0.5 * expr.similarity(mo.expr);
	  }
	  return 0;
  }
}
