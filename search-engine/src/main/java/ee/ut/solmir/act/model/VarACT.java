package ee.ut.solmir.act.model;

import ee.ut.solmir.act.SimilarityUtils;
import japa.parser.ast.Node;

public class VarACT extends ExprACT {
	private final String name;
	
	public VarACT(Node astNode, String name) {
	  super(astNode);
	  this.name = name;
  }
	
	public String getName() {
		return name;
	}

	@Override
  protected int hashCodeInternal() {
		// TODO
	  return 0;
  }
	
	@Override
	protected void prettyString(StringBuilder sb, int intentLevel) {
	  sb.append(name);
	}

	@Override
  public double similarity(ACT o) {
		if (o instanceof VarACT) {
			VarACT var = (VarACT) o;
			return SimilarityUtils.stringSimilarity(name, var.name);
		}
		else {
			return 0.0;
		}
  }
}
