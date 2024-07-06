package design_questions.elevator_system.display;

import design_questions.elevator_system.constants.ElevatorDirection;
import design_questions.elevator_system.constants.ElevatorStatus;

public interface FloorDirectionObserver {
    public void update(int elevatorId, int currentFloorNumber, ElevatorDirection currentDirection, ElevatorStatus elevatorStatus);
}
