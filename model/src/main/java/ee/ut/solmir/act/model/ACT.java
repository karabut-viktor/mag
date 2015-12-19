package ee.ut.solmir.act.model;

import ee.ut.solmir.act.model.impl.AssignACTImpl;
import ee.ut.solmir.act.model.impl.IfACTImpl;

public interface ACT {
  <T> void setAttribute(Key<T> key, T value);
  <T> T getAttribute(Key<T> key);
  <T> T removeAttribute(Key<T> key);
  
  public static IfACT cond(ExprACT expr, BlockACT thenBlock, BlockACT elseBLock) {
    return new IfACTImpl(expr, thenBlock, elseBLock);
  }
  
  public static AssignACT assign(ExprACT rValue, ExprACT lValue) {
    return new AssignACTImpl(rValue, null);
  }
}
