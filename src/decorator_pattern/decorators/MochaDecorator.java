package decorator_pattern.decorators;

import decorator_pattern.Coffee;

public class MochaDecorator extends BaseCoffeeDecorator{
    public MochaDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return super.description() + ", Mocha";
    }

    @Override
    public double cost() {
        return super.cost() + 10;
    }
}
