// https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html

public class Collections
  extends Object {
  static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key);
  static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c);
  // the index of the search key, if it is contained in the list; otherwise, (-(insertion point) - 1)
  // if return value < 0, then -(return value+1); becomes the insertion point 
  
  static <T extends Comparable<? super T>> void sort(List<T> list);
  static <T> void sort(List<T> list, Comparator<? super T> c)
}
