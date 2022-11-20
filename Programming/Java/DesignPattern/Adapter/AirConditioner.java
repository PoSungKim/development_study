package Adapter;

public class AirConditioner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("AirConditioner 220V On");
    }
}
