package ee.ut.solmir.act.model;

import japa.parser.ast.Node;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.ImmutableList;

import ee.ut.solmir.act.SimilarityUtils;

public class MethodCallACT extends ExprACT {
	private final String object;
	private final String name;
	private final List<ExprACT> args;
	
	public MethodCallACT(Node astNode, String object, String name, ExprACT... args) {
	  super(astNode);
	  this.object = object;
	  this.name = name;
	  this.args = ImmutableList.copyOf(args);
  }
	
	public MethodCallACT(Node astNode, String object, String name, List<ExprACT> args) {
		super(astNode);
		this.object = object;
		this.name = name;
		this.args = ImmutableList.copyOf(args);
	}

	public String getObject() {
		return object;
	}

	public String getName() {
		return name;
	}

	public List<ExprACT> getArgs() {
		return args;
	}
	
	@Override
	protected void prettyString(StringBuilder sb, int intentLevel) {
		if (object != null) {
			sb.append(object).append(".");
		}
	  sb.append(name).append("(");
	  for (int i = 0; i < args.size(); i++) {
	    if (i != 0) {
	    	sb.append(", ");
	    }
	    args.get(i).prettyString(sb, intentLevel);
    }
	  sb.append(")");
	}
	
	@Override
  protected int hashCodeInternal() {
	  return Objects.hash(67, args);
  }
	
	@Override
  public double similarity(ACT o) {
	  if (MethodCallACT.class.equals(o.getClass())) {
	  	MethodCallACT mo = (MethodCallACT)o;
	  	return 0.3 * SimilarityUtils.stringSimilarity(object, mo.object)
	  			+ 0.3 * SimilarityUtils.stringSimilarity(name, mo.name)
	  			+ 0.4 * SimilarityUtils.blockSimilarity(args, mo.args);
	  }
	  return 0;
  }
}
