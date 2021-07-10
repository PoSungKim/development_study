// https://docs.oracle.com/javase/7/docs/api/java/util/Set.html

public class HashSet<E>
  extends AbstractSet<E>
  implements Set<E>, Cloneable, Serializable {
  
  /*
  This class implements the Set interface, backed by a hash table (actually a HashMap instance). 
  It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. 
  
  This class permits the null element.
  */
  
  boolean add(E e);
  void    clear();

  Object  clone();

  boolean contains(Object o);

  boolean	isEmpty();
  
  Iterator<E>	iterator();

  boolean	remove(Object o);
  
  int     size();
}
 
