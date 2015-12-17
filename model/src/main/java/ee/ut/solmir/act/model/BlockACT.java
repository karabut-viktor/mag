package ee.ut.solmir.act.model;

import java.util.List;

public interface BlockACT extends ACT {
  public List<ACT> getStatements();
}
