// https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html

public class PriorityQueue<E>
  extends AbstractQueue<E>
  implements Serializable {
  // An unbounded priority queue based on a priority heap. 
  
  // The elements of the priority queue are ordered according to their natural ordering, 
  // or by a Comparator provided at queue construction time, depending on which constructor is used. 
  
  // Constructor
  PriorityQueue();
  PriorityQueue(Collection<? extends E> c);
  PriorityQueue(int initialCapacity);
  PriorityQueue(int initialCapacity, Comparator<? super E> comparator);
  PriorityQueue(PriorityQueue<? extends E> c);
  PriorityQueue(SortedSet<? extends E> c);
  
  // Methods
  boolean add(E e);
  boolean offer(E e);
  E peek();
  E poll();
  boolean remove(Object o);
  boolean contains(Object o);

  int size();
  void clear();
  Object[] toArray();
  <T> T[] toArray(T[] a);

  Comparator<? super E> comparator();
  Iterator<E> iterator();
}
