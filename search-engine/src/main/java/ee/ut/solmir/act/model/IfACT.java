package ee.ut.solmir.act.model;

import japa.parser.ast.Node;

import java.util.Objects;

public class IfACT extends ACT {
  private final ExprACT condition;
  private final BlockACT thenBranch;
  private final BlockACT elseBranch;

  public IfACT(Node astNode, ExprACT condition, BlockACT thenBranch, BlockACT elseBranch) {
    super(astNode);
    this.condition = condition;
    this.thenBranch = thenBranch;
    this.elseBranch = elseBranch;
  }

  public BlockACT getThenBranch() {
    return thenBranch;
  }

  public BlockACT getElseBranch() {
    return elseBranch;
  }

  public ExprACT getCondition() {
    return condition;
  }

  @Override
  protected void prettyString(StringBuilder sb, int intentLevel) {
    sb.append("if (");
    condition.prettyString(sb, intentLevel);
    sb.append(") {\n");
    thenBranch.prettyString(sb, intentLevel + 1);
    intent(sb, intentLevel);
    sb.append("} else {\n");
    elseBranch.prettyString(sb, intentLevel + 1);
    intent(sb, intentLevel);
    sb.append("}\n");
  }

  @Override
  protected int hashCodeInternal() {
    return Objects.hash(condition, thenBranch, elseBranch);
  }

  @Override
  public double similarity(ACT o) {
    if (IfACT.class.equals(o.getClass())) {
      IfACT mo = (IfACT) o;
      return 0.2 + 0.3 * thenBranch.similarity(mo.thenBranch) + 0.3
          * elseBranch.similarity(mo.elseBranch) + 0.2
          * condition.similarity(mo.condition);
    }
    return 0;
  }
}
