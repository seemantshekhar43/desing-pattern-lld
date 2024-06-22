package decorator_pattern.decorators;

import decorator_pattern.Coffee;

public abstract class BaseCoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public BaseCoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }


    @Override
    public String description() {
        return coffee.description();
    }

    @Override
    public double cost() {
        return coffee.cost();
    }
}
