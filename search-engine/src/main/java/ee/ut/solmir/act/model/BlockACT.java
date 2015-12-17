package ee.ut.solmir.act.model;

import japa.parser.ast.Node;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.ImmutableList;

import ee.ut.solmir.act.SimilarityUtils;

public class BlockACT extends ACT {
	private final List<ACT> children;

	public BlockACT(Node astNode, ACT... children) {
		super(astNode);
		this.children = ImmutableList.copyOf(children);
	}

	public BlockACT(Node astNode, List<ACT> children) {
		super(astNode);
		this.children = ImmutableList.copyOf(children);
	}

	public List<ACT> getChildren() {
		return children;
	}
	
	@Override
	protected void prettyString(StringBuilder sb, int intentLevel) {
		for (ACT child : children) {
			intent(sb, intentLevel);
			child.prettyString(sb, intentLevel);
			if (child instanceof ExprACT) {
				sb.append(";\n");
			}
			else {
				sb.append("\n");
			}
		}
	}

	@Override
  protected int hashCodeInternal() {
	  return Objects.hash(children.toArray());
  }

	@Override
  public double similarity(ACT o) {
	  if (BlockACT.class.equals(o.getClass())) {
	  	BlockACT mo = (BlockACT)o;
	  	return SimilarityUtils.blockSimilarity(children, mo.children);
	  }
	  return 0;
  }
}
