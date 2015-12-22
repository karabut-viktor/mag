package ee.ut.solmir.act.model;

import java.util.List;

import ee.ut.solmir.act.model.impl.AssignACTImpl;
import ee.ut.solmir.act.model.impl.BlockACTImpl;
import ee.ut.solmir.act.model.impl.CAllACTImpl;
import ee.ut.solmir.act.model.impl.IfACTImpl;
import ee.ut.solmir.act.model.impl.NumACTImpl;
import ee.ut.solmir.act.model.impl.ReturnACTImpl;
import ee.ut.solmir.act.model.impl.ThrowACTImpl;
import ee.ut.solmir.act.model.impl.TryCatchACTImpl;
import ee.ut.solmir.act.model.impl.VarACTImpl;
import ee.ut.solmir.act.model.impl.WhileACTImpl;

public interface ACT {
  <T> void setAttribute(Key<T> key, T value);
  <T> T getAttribute(Key<T> key);
  <T> T removeAttribute(Key<T> key);
  
  public static AssignACT assign(ExprACT rValue, ExprACT lValue) {
    return new AssignACTImpl(rValue, null);
  }
  
  public static BlockACT block(ACT... statements) {
    return new BlockACTImpl(statements);
  }
  
  public static BlockACT block(List<ACT> statements) {
    return new BlockACTImpl(statements.toArray(new ACT[0]));
  }
  
  public static IfACT cond(ExprACT expr, BlockACT thenBlock, BlockACT elseBLock) {
    return new IfACTImpl(expr, thenBlock, elseBLock);
  }
  
  public static CallACT call(String name, ExprACT... args) {
    return new CAllACTImpl(name, args);
  }
  
  public static CallACT call(String name, List<ExprACT> args) {
    return new CAllACTImpl(name, args.toArray(new ExprACT[0]));
  }
  
  public static NumACT num(double num) {
    return new NumACTImpl(num);
  }
  
  public static ReturnACT ret(ExprACT expr) {
    return new ReturnACTImpl(expr);
  }
  
  public static ThrowACT thr(ExprACT expr) {
    return new ThrowACTImpl(expr);
  }
  
  public static TryCatchACT tryCatch(BlockACT tryBlock, BlockACT catchBlock) {
    return new TryCatchACTImpl(tryBlock, catchBlock);
  }
  
  public static VarACT var(ExprACT holder, String name) {
    return new VarACTImpl(holder, name);
  }
  
  public static WhileACT whl(ExprACT cond, BlockACT block) {
    return new WhileACTImpl(cond, block);
  }
}
