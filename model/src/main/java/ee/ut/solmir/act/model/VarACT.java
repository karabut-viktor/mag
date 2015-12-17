package ee.ut.solmir.act.model;

public interface VarACT extends ExprACT {
  ExprACT getHolder();
  String getName();
}
