package abstract_factory_pattern;

import abstract_factory_pattern.factories.GUIFactory;
import abstract_factory_pattern.products.Button;
import abstract_factory_pattern.products.TextField;

public class GUIApplication {
    private Button button;
    private TextField textField;

    public GUIApplication(GUIFactory guiFactory) {
        this.button = guiFactory.createButton();
        this.textField = guiFactory.createTextField();
    }

    public void renderUI(){
        button.paint();
        textField.render();
    }
}
