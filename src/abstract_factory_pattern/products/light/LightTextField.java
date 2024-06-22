package abstract_factory_pattern.products.light;

import abstract_factory_pattern.products.TextField;

public class LightTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering a light theme text field!");
    }
}
