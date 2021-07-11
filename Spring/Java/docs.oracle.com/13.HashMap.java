// https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

public class HashMap<K,V>
  extends AbstractMap<K,V>
  implements Map<K,V>, Cloneable, Serializable {

  void      clear();
  Object    clone();
  
  boolean   containsKey(Object key);
  boolean   containsValue(Object value);
  
  V         get(Object key);
  V         getOrDefault(Object key, V defaultValue);
  
  boolean   isEmpty();
  
  V         put(K key, V value);
  void      putAll(Map<? extends K,? extends V> m);
  
  V         remove(Object key);
  boolean   remove(Object key, Object value);
  
  int       size();
}
