// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

// ArrayList cannot take primitive data type like int and double
// it can only take reference data type like Integer, Double, String

public class ArrayList<E>
  extends AbstractList<E>
  implements List<E>, RandomAccess, Cloneable, Serializable {
  
  /*
  Instances of the class Class represent classes and interfaces in a running Java application. An enum is a kind of class and an annotation is a kind of interface. Every array also belongs to a class that is reflected as a Class object that is shared by all arrays with the same element type and number of dimensions. The primitive Java types (boolean, byte, char, short, int, long, float, and double), and the keyword void are also represented as Class objects.
  Class has no public constructor. Instead Class objects are constructed automatically by the Java Virtual Machine as classes are loaded and by calls to the defineClass method in the class loader.
  */
  
  int       size()
  boolean   add(E e)
  boolean   addAll(Collection<? extends E> c)
  E         remove(int index)
  E         get(int index)
  E         set(int index, E element)

}

