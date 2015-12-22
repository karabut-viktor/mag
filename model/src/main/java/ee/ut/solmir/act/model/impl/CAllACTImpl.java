package ee.ut.solmir.act.model.impl;

import java.util.Arrays;
import java.util.List;

import ee.ut.solmir.act.model.CallACT;
import ee.ut.solmir.act.model.ExprACT;

public class CAllACTImpl extends AbstractACT implements CallACT {
  private final List<ExprACT> args;
  private final String name;
  
  public CAllACTImpl(String name, ExprACT... args) {
    this.name = name;
    this.args = Arrays.asList(args);
    assertNotNull(name, "name");
    assertAllNotNull(this.args, "args");
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<ExprACT> args() {
    return args;
  }

  @Override
  public int hashCode() {
    final int prime = 31; // TODO bigger prime
    int result = 1;
    result = prime * result + args.hashCode();
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
    
    CAllACTImpl other = (CAllACTImpl) obj;
    return args.equals(other.args) && name.equals(other.name);
  }
}
