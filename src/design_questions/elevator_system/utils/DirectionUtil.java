package design_questions.elevator_system.utils;

import design_questions.elevator_system.constants.ElevatorDirection;

public class DirectionUtil {
    public static ElevatorDirection getElevatorDirection(int currentFloorId, int destinationFloorId){
        return currentFloorId < destinationFloorId ? ElevatorDirection.UP : ElevatorDirection.DOWN;
    }
}
