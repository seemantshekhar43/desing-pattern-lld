package design_questions.elevator_system;

import design_questions.elevator_system.button.ExternalButton;
import design_questions.elevator_system.button.ExternalDirectionButton;
import design_questions.elevator_system.button.ExternalNumericButton;
import design_questions.elevator_system.constants.ElevatorDirection;
import design_questions.elevator_system.display.Display;

public class Floor {
    private final int floorId;
    private final Display display;

    private final ExternalButton<Integer> externalNumericButton;
    private final ExternalButton<ElevatorDirection> externalDirectionButton;

    public Floor(int floorId, Display display, ExternalButton<Integer> externalNumericButton, ExternalButton<ElevatorDirection> externalDirectionButton) {
        this.floorId = floorId;
        this.display = display;
        this.externalNumericButton = externalNumericButton;
        this.externalDirectionButton = externalDirectionButton;
    }

    public int getFloorId() {
        return floorId;
    }

    public Display getDisplay() {
        return display;
    }

    public ExternalButton<Integer> getExternalNumericButton() {
        return externalNumericButton;
    }

    public ExternalButton<ElevatorDirection> getExternalDirectionButton() {
        return externalDirectionButton;
    }
}
