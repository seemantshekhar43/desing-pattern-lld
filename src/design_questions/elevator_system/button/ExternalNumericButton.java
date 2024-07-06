package design_questions.elevator_system.button;

import design_questions.elevator_system.button_dispatcher.ButtonDispatcher;

import java.util.Map;

public class ExternalNumericButton extends ExternalButton<Integer>{
    public ExternalNumericButton(Map<String, Integer> labels,  int currentFloorId) {
        super(labels, currentFloorId);
    }

    @Override
    public void onPress(String label) {
        if(!super.getLabels().containsKey(label)){
            throw new RuntimeException("Invalid Floor Number");
        }
        int destinationFloorId = super.getLabels().get(label);
        super.getButtonDispatcher().submitRequest(super.getCurrentFloorId(),  destinationFloorId);
    }
}
