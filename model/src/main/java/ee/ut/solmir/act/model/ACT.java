package ee.ut.solmir.act.model;

public interface ACT {
  <T> void setAttribute(Key<T> key, T value);
  <T> T getAttribute(Key<T> key);
  <T> T removeAttribute(Key<T> key);
}
