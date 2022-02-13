package Decorator;

public class Tesla implements ICar {

    private int price;

    public Tesla(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void showPrice() {
        System.out.println("Tesla의 가격은 " + price + "원 입니다.");
    }
}
