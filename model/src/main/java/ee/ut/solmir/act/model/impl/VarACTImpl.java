package ee.ut.solmir.act.model.impl;

import ee.ut.solmir.act.model.ExprACT;
import ee.ut.solmir.act.model.VarACT;

public class VarACTImpl extends AbstractACT implements VarACT {
  private final ExprACT holder;
  private final String name;
  
  public VarACTImpl(ExprACT holder, String name) {
    assertNotNull(holder, "holder");
    assertNotNull(name, "name");
    
    this.holder = holder;
    this.name = name;
  }

  @Override
  public ExprACT getHolder() {
    return holder;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + holder.hashCode();
    result = prime * result + name.hashCode();
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
    
    VarACTImpl other = (VarACTImpl) obj;
    return holder.equals(other.holder) && name.equals(other.name);
  }

}
