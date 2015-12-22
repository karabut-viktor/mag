package ee.ut.solmir.act.model.impl;

import ee.ut.solmir.act.model.NumACT;

public class NumACTImpl extends AbstractACT implements NumACT {
  private final double value;
  
  public NumACTImpl(double value) {
    this.value = value;
  }
  
  @Override
  public double getValue() {
    return value;
  }

  @Override
  public int hashCode() {
    final int prime = 31; // TODO better number
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(value);
    result = prime * result + (int) (temp ^ (temp >>> 32));
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
    
    NumACTImpl other = (NumACTImpl) obj;
    if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
      return false;
    return true;
  }
  
  
}
