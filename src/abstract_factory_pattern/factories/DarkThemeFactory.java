package abstract_factory_pattern.factories;

import abstract_factory_pattern.products.Button;
import abstract_factory_pattern.products.TextField;
import abstract_factory_pattern.products.dark.DarkButton;
import abstract_factory_pattern.products.dark.DarkTextField;

public class DarkThemeFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public TextField createTextField() {
        return new DarkTextField();
    }
}
