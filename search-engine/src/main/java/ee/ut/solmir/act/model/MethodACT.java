package ee.ut.solmir.act.model;

import japa.parser.ast.Node;

public class MethodACT extends ACT {
	private final BlockACT body;
	private final String name;
	
	public MethodACT(Node astNode, String name, BlockACT body) {
		super(astNode);
		this.body = body;
		this.name = name;
	}
	
	public ACT getBody() {
		return body;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
  protected void prettyString(StringBuilder sb, int intentLevel) {
	  intent(sb, intentLevel);
	  sb.append("method ").append(name).append(" () {\n");
	  body.prettyString(sb, intentLevel + 1);
	  intent(sb, intentLevel);
	  sb.append("}\n");
	}

	@Override
  protected int hashCodeInternal() {
	  return body.hashCode();
  }

	@Override
  public double similarity(ACT o) {
	  if (MethodACT.class.equals(o.getClass())) {
	  	MethodACT mo = (MethodACT)o;
	  	return body.similarity(mo.body);
	  }
	  return 0;
  }
}
