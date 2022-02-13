package Decorator;

public class TeslaDecorator implements ICar{

    protected ICar tesla;
    protected String modelName;
    protected int modelPrice;

    public TeslaDecorator(ICar tesla, String modelName, int modelPrice){
        this.tesla = tesla;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }

    @Override
    public int getPrice() {
        return tesla.getPrice() + modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelName + "의 가격은 " + getPrice() + " 원 입니다");
    }
}
