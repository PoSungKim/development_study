package Decorator;

public class X extends TeslaDecorator{
    public X(ICar tesla, String modelName) {
        super(tesla, modelName, 1000);
    }
}
