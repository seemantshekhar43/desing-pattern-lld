package abstract_factory_pattern.factories;

import abstract_factory_pattern.products.Button;
import abstract_factory_pattern.products.TextField;
import abstract_factory_pattern.products.light.LightButton;
import abstract_factory_pattern.products.light.LightTextField;

public class LightThemeFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public TextField createTextField() {
        return new LightTextField();
    }
}
