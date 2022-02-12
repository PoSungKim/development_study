package Singleton;

public class BObj {
    private final SocketClient socketClient;

    public BObj() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
