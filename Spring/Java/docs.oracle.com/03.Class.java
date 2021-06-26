// https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html

public final class Class<T>
  extends Object
  implements Serializable, GenericDeclaration, Type, AnnotatedElement {
  
  /*
  Instances of the class Class represent classes and interfaces in a running Java application. An enum is a kind of class and an annotation is a kind of interface. Every array also belongs to a class that is reflected as a Class object that is shared by all arrays with the same element type and number of dimensions. The primitive Java types (boolean, byte, char, short, int, long, float, and double), and the keyword void are also represented as Class objects.
  Class has no public constructor. Instead Class objects are constructed automatically by the Java Virtual Machine as classes are loaded and by calls to the defineClass method in the class loader.
  */
  
  String    getName()
  Package   getPackage()
  Method[]  getMethods()
}

class GetClass {
    public void getClass(Class inputClass) {
    
        Class testClass = inputClass.class;
        //Class testClass = inputClass.getClass();
        Method[] methods = testClass.getMethods();
        
        for(Method method : methods)
          System.out.println(method);
        
    }
}

