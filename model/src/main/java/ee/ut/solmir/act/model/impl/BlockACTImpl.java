package ee.ut.solmir.act.model.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ee.ut.solmir.act.model.ACT;
import ee.ut.solmir.act.model.BlockACT;

public class BlockACTImpl extends AbstractACT implements BlockACT {
  private final List<ACT> statements;

  public BlockACTImpl(ACT... statements) {
    this.statements = Arrays.asList(statements);
    assertAllNotNull(this.statements, "statements");
  }
  
  @Override
  public List<ACT> getStatements() {
    return Collections.unmodifiableList(statements);
  }

  @Override
  public int hashCode() {
    final int prime = 31; // TODO prime number
    int result = 1;
    result = prime * result + statements.hashCode() ;
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
    
    BlockACTImpl other = (BlockACTImpl) obj;
    return (!statements.equals(other.statements));
  }
  
}
