package ee.ut.solmir.act.model.impl;

import java.util.HashMap;
import java.util.Map;

import ee.ut.solmir.act.model.ACT;
import ee.ut.solmir.act.model.Key;

class AbstractACT implements ACT {
  private Map<String, Object> map;

  @Override
  public <T> void setAttribute(Key<T> key, T value) {
    if (map == null) 
      map = new HashMap<>();
    
    map.put(key.getId(), value);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getAttribute(Key<T> key) {
    if (map == null)
      return null;
    
    return (T) map.get(key.getId());
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T removeAttribute(Key<T> key) {
    if (map == null)
      return null;
    
    return (T) map.remove(key.getId());
  }
  
  final protected void assertNotNull(Object o, String name) throws IllegalArgumentException {
    if (o == null) {
      throw new IllegalArgumentException(String.format("Argument %s cannot be null.", name));
    }
  }
  
  final protected void assertAllNotNull(Iterable<? extends Object> os, String name) {
    assertNotNull(os, name);
    for (Object o : os) {
      if (o == null) {
        throw new IllegalArgumentException(String.format("Iterable %s contains null element.", name));
      }
    }
  }
  
}
