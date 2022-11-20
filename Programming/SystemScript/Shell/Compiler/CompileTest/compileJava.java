package CompileTest;

import java.util.Scanner;

public class compileJava {
    public static void main(String[] args) {
        Test.main(args);
        Test2.main(args);
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("Test");
    }
}

class Test2 {
    public static void main(String[] args) {
        System.out.println("Test2");
    }
}