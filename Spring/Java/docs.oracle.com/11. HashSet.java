// https://docs.oracle.com/javase/7/docs/api/java/util/Set.html

public class HashSet<E>
  extends AbstractSet<E>
  implements Set<E>, Cloneable, Serializable {
  
  /*
  Resizable-array implementation of the Deque interface. 
  Array deques have no capacity restrictions; 
  they grow as necessary to support usage. 
  
  They are not thread-safe; 
  in the absence of external synchronization, they do not support concurrent access by multiple threads. 
  Null elements are prohibited. 

  This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
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
 
