package ee.ut.solmir.mag.act.model;

import java.util.Objects;

import japa.parser.ast.Node;

public class WhileACT extends ACT {
	private final ACT precondition;
	private final BlockACT body;
	
	public WhileACT(Node astNode, ACT precondition, BlockACT body) {
	  super(astNode);
	  this.precondition = precondition;
	  this.body = body;
  }

	public ACT getPrecondition() {
	  return precondition;
  }

	public ACT getBody() {
	  return body;
  }
	
	@Override
	protected void prettyString(StringBuilder sb, int intentLevel) {
	  sb.append("while (");
	  precondition.prettyString(sb, intentLevel);
	  sb.append(") {\n");
	  body.prettyString(sb, intentLevel + 1);
	  intent(sb, intentLevel);
	  sb.append("}\n");
	}

	@Override
  protected int hashCodeInternal() {
	 return Objects.hash(precondition, body);
  }
	
	@Override
  public double similarity(ACT o) {
	  if (WhileACT.class.equals(o.getClass())) {
	  	WhileACT mo = (WhileACT)o;
	  	return 0.2 + 0.4 * body.similarity(mo.body)
	  			+ 0.4 * precondition.similarity(mo.precondition);
	  }
	  return 0;
  }
}
