package abstract_factory_pattern.products.dark;

import abstract_factory_pattern.products.TextField;

public class DarkTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering a dark theme text field!");
    }
}
