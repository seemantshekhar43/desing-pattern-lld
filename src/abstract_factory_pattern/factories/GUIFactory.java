package abstract_factory_pattern.factories;

import abstract_factory_pattern.products.Button;
import abstract_factory_pattern.products.TextField;

public interface GUIFactory {
    Button createButton();
    TextField createTextField();
}
