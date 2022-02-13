package Strategy;

public class Main {

    public static void main(String[] args){
        Encoder encoder = new Encoder();

        // Base64
        EncodingStrategy base64 = new Base64Strategy();

        // Normal
        EncodingStrategy normal = new NormalStrategy();

        // Append
        EncodingStrategy append = new AppendStrategy();

        String message = "Hello Pskim!";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(append);
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }
}
