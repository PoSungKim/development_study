// https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

public class HashMap<K,V>
  extends AbstractMap<K,V>
  implements Map<K,V>, Cloneable, Serializable {
  
  /*
  Hash table based implementation of the Map interface. 
  This class makes no guarantees as to the order of the map; in particular, it does not guarantee that the order will remain constant over time.
  */
  
  void      clear()
  boolean   containsKey(Object key)
  boolean   containsValue(Object value)
  V         get(Object key)
  V         getOrDefault(Object key, V defaultValue)
  boolean   isEmpty()
  V         put(K key, V value)
  V         remove(Object key)
  Set<K>    keySet()
  Collection<V> alues()
}

