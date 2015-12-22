package ee.ut.solmir.act.model.impl;

import ee.ut.solmir.act.model.BlockACT;
import ee.ut.solmir.act.model.TryCatchACT;

public class TryCatchACTImpl extends AbstractACT implements TryCatchACT {
  private final BlockACT tryBlock;
  private final BlockACT catchBlock;
  
  public TryCatchACTImpl(BlockACT tryBlock, BlockACT catchBlock) {
    assertNotNull(tryBlock, "tryBlock");
    assertNotNull(catchBlock, "catchBlock");
    
    this.tryBlock = tryBlock;
    this.catchBlock = catchBlock;
  }
  
  @Override
  public BlockACT getTryBlock() {
    return tryBlock;
  }

  @Override
  public BlockACT getCatchBlock() {
    return catchBlock;
  }

  @Override
  public int hashCode() {
    final int prime = 31; // TODO better prime
    int result = 1;
    result = prime * result + catchBlock.hashCode();
    result = prime * result + tryBlock.hashCode();
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
    
    TryCatchACTImpl other = (TryCatchACTImpl) obj;
    return catchBlock.equals(other.catchBlock) && tryBlock.equals(other.tryBlock);
  }
  
}
