package ee.ut.solmir.act.model.impl;

import javax.validation.constraints.NotNull;

import ee.ut.solmir.act.model.AssignACT;
import ee.ut.solmir.act.model.ExprACT;

public class AssignACTImpl extends AbstractACT implements AssignACT {
  private final ExprACT rValue;
  private final ExprACT lValue;
  
  public AssignACTImpl(@NotNull ExprACT rValue, @NotNull ExprACT lValue) {
    this.rValue = rValue;
    this.lValue = lValue;
  }

  @Override
  public ExprACT getRValue() {
    return rValue;
  }

  @Override
  public ExprACT getLValue() {
    return lValue;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((lValue == null) ? 0 : lValue.hashCode());
    result = prime * result + ((rValue == null) ? 0 : rValue.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof AssignACTImpl))
      return false;
    AssignACTImpl other = (AssignACTImpl) obj;
    if (lValue == null) {
      if (other.lValue != null)
        return false;
    }
    else if (!lValue.equals(other.lValue))
      return false;
    if (rValue == null) {
      if (other.rValue != null)
        return false;
    }
    else if (!rValue.equals(other.rValue))
      return false;
    return true;
  }
}
