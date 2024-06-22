package decorator_pattern.decorators;

import decorator_pattern.Coffee;

public class MilkDecorator extends BaseCoffeeDecorator{
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return super.description() + ", Milk" ;
    }

    @Override
    public double cost() {
        return super.cost() + 5;
    }
}
