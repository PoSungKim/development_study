package Decorator;

public class Main {

    public static void main(String[] args) {
        ICar tesla = new Tesla(10000);
        tesla.showPrice();

        // X
        ICar teslaX = new X(tesla, "X");
        teslaX.showPrice();
        // Y
        ICar teslaY = new Y(tesla, "Y");
        teslaY.showPrice();
        // S
        ICar teslaS = new S(tesla, "S");
        teslaS.showPrice();
    }
}
