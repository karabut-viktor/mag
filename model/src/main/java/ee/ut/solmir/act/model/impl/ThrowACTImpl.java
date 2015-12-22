package ee.ut.solmir.act.model.impl;

import ee.ut.solmir.act.model.ExprACT;
import ee.ut.solmir.act.model.ThrowACT;

public class ThrowACTImpl extends AbstractACT implements ThrowACT {
  private final ExprACT value;
  
  public ThrowACTImpl(ExprACT value) {
    assertNotNull(value, "value");
    this.value = value;
  }
  
  @Override
  public ExprACT getValue() {
    return value;
  }

  @Override
  public int hashCode() {
    final int prime = 31; // better prime
    int result = 1;
    result = prime * result + value.hashCode();
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
    
    ThrowACTImpl other = (ThrowACTImpl) obj;
    return value.equals(other.value);
  }

}
