package ee.ut.solmir.act.model;

public interface IfACT extends ACT {
  BlockACT getThenBlock();
  BlockACT getElseBlock();
  ExprACT getExpr();
}
