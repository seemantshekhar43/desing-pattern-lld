package decorator_pattern;

import decorator_pattern.decorators.MilkDecorator;
import decorator_pattern.decorators.MochaDecorator;

public class Main {
    /*
    Problem statement:
        Imagine you are developing a coffee shop application where customers can order different types of coffee and customize them with
        various condiments (e.g., milk, soy, mocha, whip). The basic coffee class should be extendable to add these condiments dynamically.
     */


    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.description() + " | Cost: " + coffee.cost());

        Coffee coffeeWithMilk = new MilkDecorator(coffee);
        System.out.println(coffeeWithMilk.description() + " | Cost: " + coffeeWithMilk.cost());

        Coffee coffeeWithMilkAndMocha = new MochaDecorator(coffeeWithMilk);
        System.out.println(coffeeWithMilkAndMocha.description() + " | Cost: " + coffeeWithMilkAndMocha.cost());
    }

    /*
    Advantages:

    1. Single Responsibility Principle: You can divide functionality between classes with unique areas of concern.
    2. Open/Closed Principle: You can extend the behavior of objects without modifying their code.
    3. Flexibility: You can combine multiple decorators to create complex behaviors.
    4. Runtime Behavior: You can add responsibilities to objects at runtime rather than at compile-time.

     */

}
