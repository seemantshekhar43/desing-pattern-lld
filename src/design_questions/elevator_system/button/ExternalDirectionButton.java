package design_questions.elevator_system.button;

import design_questions.elevator_system.constants.ElevatorDirection;
import design_questions.elevator_system.button_dispatcher.ButtonDispatcher;

import java.util.Map;

public class ExternalDirectionButton extends ExternalButton<ElevatorDirection>{
    public ExternalDirectionButton(Map<String, ElevatorDirection> labels,  int currentFloorId) {
        super(labels, currentFloorId);
    }

    @Override
    public void onPress(String label) {
        if(!super.getLabels().containsKey(label)){
            throw new RuntimeException("Invalid Floor Number");
        }
        ElevatorDirection direction = super.getLabels().get(label);
        if((super.getCurrentFloorId() == 0 && direction.equals(ElevatorDirection.DOWN))){
            throw new RuntimeException("Invalid Floor Number");
        }
        super.getButtonDispatcher().submitRequest(super.getCurrentFloorId(),  direction);
    }
}
