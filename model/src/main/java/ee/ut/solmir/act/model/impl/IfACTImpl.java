package ee.ut.solmir.act.model.impl;

import ee.ut.solmir.act.model.BlockACT;
import ee.ut.solmir.act.model.ExprACT;
import ee.ut.solmir.act.model.IfACT;

public class IfACTImpl extends AbstractACT implements IfACT {
  private final ExprACT expr;
  private final BlockACT thenBlock;
  private final BlockACT elseBLock;

  public IfACTImpl(ExprACT expr, BlockACT thenBlock, BlockACT elseBLock) {
    this.expr = expr;
    this.thenBlock = thenBlock;
    this.elseBLock = elseBLock;
  }
  
  @Override
  public BlockACT getThenBlock() {
    return thenBlock;
  }

  @Override
  public BlockACT getElseBlock() {
    return elseBLock;
  }

  @Override
  public ExprACT getExpr() {
    return expr;
  }
}
