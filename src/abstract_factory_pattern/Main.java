package abstract_factory_pattern;

import abstract_factory_pattern.factories.DarkThemeFactory;
import abstract_factory_pattern.factories.GUIFactory;
import abstract_factory_pattern.factories.LightThemeFactory;

public class Main {

    /*
    Problem Statement:

    Imagine you are developing a UI framework that supports different themes, such as a light theme and a dark theme.
    Each theme has a family of related components like buttons, text fields, and checkboxes. You want to create a family
    of UI components based on the selected theme.


     */

    private static  GUIApplication configureApplication(){

        GUIFactory guiFactory;

        String[] themes = {"light", "dark"};

        // some logic to select theme
        String theme = themes[((int)(Math.random()* 10000))%2];

        if(theme.equals("light")){
            guiFactory = new LightThemeFactory();
        }else{
            guiFactory = new DarkThemeFactory();
        }

        return new GUIApplication(guiFactory);
    }

    public static void main(String[] args) {
        GUIApplication application = configureApplication();
        application.renderUI();
    }
    /*
    Advantages:
    1. Open/Closed Principle: You can extend the behavior of objects without modifying their code.
    2. Promotes loose coupling.
     */
}
