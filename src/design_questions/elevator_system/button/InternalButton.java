package design_questions.elevator_system.button;

import design_questions.elevator_system.button_dispatcher.ButtonDispatcher;

import java.util.Map;

public class InternalButton extends Button<Integer>{

    public InternalButton(Map<String, Integer> labels) {
        super(labels);
    }

    @Override
    public void onPress(String label) {
        if(!super.getLabels().containsKey(label)){
            throw new RuntimeException("Invalid Floor Number");
        }
        int destinationFloorId = super.getLabels().get(label);
        // current floorId is not required so not passing it
        super.getButtonDispatcher().submitRequest(-1, destinationFloorId);
    }
}
