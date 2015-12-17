package ee.ut.solmir.act.model;

public interface WhileACT extends ACT{
  ExprACT getCondition();
  BlockACT getBody();
}
