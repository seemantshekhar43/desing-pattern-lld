package decorator_pattern;

public class SimpleCoffee implements Coffee{
    @Override
    public String description() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 20.0;
    }
}
