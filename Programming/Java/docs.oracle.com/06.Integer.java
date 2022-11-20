// https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html

public final class Integer
  extends Number
  implements Comparable<Integer> {
  
  /*
  The Integer class wraps a value of the primitive type int in an object. An object of type Integer contains a single field whose type is int.
  In addition, this class provides several methods for converting an int to a String and a String to an int, as well as other constants and methods useful when dealing with an int.  */
  
  static String toString(int i);
  static int    parseInt(String s);
  
  static int    bitCount(int i);
  static int    reverse(int i);
  
  static String toBinaryString(int i);
  static String toHexString(int i);
  static String toOctalString(int i);
  
  String        toString();
  static String toString(int i);
  static String toString(int i, int radix);

  static Integer valueOf(int i);
  static Integer valueOf(String s);
  static Integer valueOf(String s, int radix);
}
