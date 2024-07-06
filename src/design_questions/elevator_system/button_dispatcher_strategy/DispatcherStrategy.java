package design_questions.elevator_system.button_dispatcher_strategy;

import design_questions.elevator_system.ElevatorController;
import design_questions.elevator_system.constants.ElevatorDirection;

import java.util.List;

public interface DispatcherStrategy {
    public ElevatorController findElevatorController(List<ElevatorController> elevatorControllerList, int currentFloorId, ElevatorDirection elevatorDirection);
}
