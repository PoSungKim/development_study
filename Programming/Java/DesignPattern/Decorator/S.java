package Decorator;

public class S extends TeslaDecorator{
    public S(ICar tesla, String modelName) {
        super(tesla, modelName, 3000);
    }
}
