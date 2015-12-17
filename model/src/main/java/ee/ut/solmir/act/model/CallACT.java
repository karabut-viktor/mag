package ee.ut.solmir.act.model;

import java.util.List;

public interface CallACT extends ExprACT {
  String getName();
  List<ExprACT> args();
}
