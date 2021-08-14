import CompileTest.compileJava;

public class importJava {
    public static void main(String[] args) {
        System.out.println("Import Java...");
        compileJava.main(args); // static method이기 때문에, 인스턴스화 필요 없이 Class에서 바로 메소드 사용 가능
    }
}