package ee.ut.solmir.act.model.impl;

import ee.ut.solmir.act.model.BlockACT;
import ee.ut.solmir.act.model.ExprACT;
import ee.ut.solmir.act.model.WhileACT;

public class WhileACTImpl extends AbstractACT implements WhileACT {
  private final ExprACT condition;
  private final BlockACT body;
  
  public WhileACTImpl(ExprACT condition, BlockACT body) {
    assertNotNull(condition, "condition");
    assertNotNull(body, "body");
    
    this.condition = condition;
    this.body = body;
  }

  @Override
  public ExprACT getCondition() {
    return condition;
  }

  @Override
  public BlockACT getBody() {
    return body;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + body.hashCode();
    result = prime * result + condition.hashCode();
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    
    WhileACTImpl other = (WhileACTImpl) obj;
    return body.equals(other.body) && condition.equals(other.condition);
  }

}
