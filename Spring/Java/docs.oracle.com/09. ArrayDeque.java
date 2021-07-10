// https://docs.oracle.com/javase/7/docs/api/java/util/ArrayDeque.html

public class ArrayDeque<E>
  extends AbstractCollection<E>
  implements Deque<E>, Cloneable, Serializable {
  
  /*
  Resizable-array implementation of the Deque interface. Array deques have no capacity restrictions; they grow as necessary to support usage. They are not thread-safe; in the absence of external synchronization, they do not support concurrent access by multiple threads. Null elements are prohibited. 

  This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
  */
  
  void          clear();
  ArrayDeque<E> clone();
  
  boolean       contains(Object o);
  
  boolean       add(E e);
  void          addFirst(E e);
  void          addLast(E e);
  
  E             getFirst();
  E             getLast();
  
  E             removeFirst();
  E             removeLast();
  
  int           size();
  Object[]      toArray();
}
