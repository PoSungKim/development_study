package Singleton;

public class SocketClient {
    private static SocketClient socketClient = null;

    // 기본 생성자를 private 선언으로 막아주기
    private SocketClient() {

    }

    public static SocketClient getInstance() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }

        return socketClient;
    }

    public void connect() {
        System.out.println("Connect");
    }
}
