// https://docs.oracle.com/javase/7/docs/api/java/util/Set.html 


public interface Set<E>
  extends Collection<E> {

  boolean addAll(Collection<? extends E> c)
  boolean containsAll(Collection<?> c)
  boolean removeAll(Collection<?> c)

  boolean retainAll(Collection<?> c)
  
  Object[] toArray()
}
