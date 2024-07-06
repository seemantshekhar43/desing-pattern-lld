package design_questions.elevator_system.button;

import design_questions.elevator_system.button_dispatcher.ButtonDispatcher;

import java.util.Map;

public abstract class Button<T> {
    private final Map<String, T> labels;
    private  ButtonDispatcher<T> buttonDispatcher;

    public Button(Map<String, T> labels) {
        this.labels = labels;
    }

    public void setButtonDispatcher(ButtonDispatcher<T> buttonDispatcher) {
        this.buttonDispatcher = buttonDispatcher;
    }

    public abstract void onPress(String label);

    public Map<String, T> getLabels() {
        return labels;
    }

    public ButtonDispatcher<T> getButtonDispatcher() {
        return buttonDispatcher;
    }
}
