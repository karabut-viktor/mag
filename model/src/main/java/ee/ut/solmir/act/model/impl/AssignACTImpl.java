package ee.ut.solmir.act.model.impl;

import ee.ut.solmir.act.model.AssignACT;
import ee.ut.solmir.act.model.ExprACT;

public class AssignACTImpl extends AbstractACT implements AssignACT {
  private final ExprACT rValue;
  private final ExprACT lValue;
  
  public AssignACTImpl(ExprACT rValue, ExprACT lValue) {
    assertNotNull(lValue, "lValue");
    assertNotNull(rValue, "rValue");
    
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
    result = prime * result + lValue.hashCode();
    result = prime * result + rValue.hashCode();
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
    if (!lValue.equals(other.lValue))
      return false;
    if (!rValue.equals(other.rValue))
      return false;
    
    return true;
  }
}
