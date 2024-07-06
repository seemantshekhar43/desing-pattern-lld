package design_questions.elevator_system.button_dispatcher;

import design_questions.elevator_system.ElevatorController;
import design_questions.elevator_system.constants.ElevatorDirection;

public interface ExternalButtonDispatcher<T> extends ButtonDispatcher<T>{
     ElevatorController getElevatorController(int currentFloorId, ElevatorDirection elevatorDirection);
}
