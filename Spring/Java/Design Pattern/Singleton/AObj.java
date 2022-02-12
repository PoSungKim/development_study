package Singleton;

public class AObj {
    private final SocketClient socketClient;

    public AObj() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
