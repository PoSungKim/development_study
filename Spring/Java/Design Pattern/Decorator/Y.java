package Decorator;

public class Y extends TeslaDecorator{
    public Y(ICar tesla, String modelName) {
        super(tesla, modelName, 2000);
    }
}
