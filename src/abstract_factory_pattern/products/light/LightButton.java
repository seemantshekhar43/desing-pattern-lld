package abstract_factory_pattern.products.light;

import abstract_factory_pattern.products.Button;

public class LightButton implements Button {

    @Override
    public void paint() {
        System.out.println("Rendering a light theme button!");
    }
}
