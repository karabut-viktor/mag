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
  
  private void checkNull(Object o, String name) {
    
  }
  
}
