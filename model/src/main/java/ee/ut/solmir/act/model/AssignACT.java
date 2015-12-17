package ee.ut.solmir.act.model;

public interface AssignACT extends ExprACT {
  ExprACT getRValue();
  ExprACT getLValue();
}
