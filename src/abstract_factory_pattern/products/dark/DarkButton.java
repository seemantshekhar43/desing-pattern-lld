package abstract_factory_pattern.products.dark;

import abstract_factory_pattern.products.Button;

public class DarkButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a dark theme button!");
    }
}
