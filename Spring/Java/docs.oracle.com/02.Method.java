// https://docs.oracle.com/javase/7/docs/api/java/lang/reflect/Method.html

public final class Method 
  extends AccessibleObject
  implements GenericDeclaration, Member {
  /*
  A Method provides information about, and access to, a single method on a class or interface. The reflected method may be a class method or an instance method (including an abstract method).
  A Method permits widening conversions to occur when matching the actual parameters to invoke with the underlying method's formal parameters, but it throws an IllegalArgumentException if a narrowing conversion would occur.
  */

  String      getDeclaringClass()
  String.     getName()
  Class<?>[]  getParameterTypes()
  Class<?>    getReturnType()
  String      toGenericString()
  String      toString()
}
