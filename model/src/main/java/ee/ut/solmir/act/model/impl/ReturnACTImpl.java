package ee.ut.solmir.act.model.impl;

import ee.ut.solmir.act.model.ExprACT;
import ee.ut.solmir.act.model.ReturnACT;

public class ReturnACTImpl extends AbstractACT implements ReturnACT {
  private final ExprACT value;
  
  public ReturnACTImpl(ExprACT value) {
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
    
    ReturnACTImpl other = (ReturnACTImpl) obj;
    return value.equals(other.value);
  }

}
