package design_questions.elevator_system.button_dispatcher_strategy;

import design_questions.elevator_system.ElevatorController;
import design_questions.elevator_system.constants.ElevatorDirection;

import java.util.List;

public class SameDirectionDispatcherStrategy implements DispatcherStrategy{
    @Override
    public ElevatorController findElevatorController(List<ElevatorController> elevatorControllerList, int currentFloorId, ElevatorDirection elevatorDirection) {
        if(elevatorControllerList.isEmpty()){
            throw new RuntimeException("No elevator found for: " + currentFloorId);
        }

        for(ElevatorController elevatorController : elevatorControllerList){
            if(elevatorController.getElevatorDirection().equals(elevatorDirection)){
                if(elevatorDirection == ElevatorDirection.UP && elevatorController.getElevatorCurrentFloorId() < currentFloorId){
                    return elevatorController;
                }

                if(elevatorDirection == ElevatorDirection.DOWN && elevatorController.getElevatorCurrentFloorId() > currentFloorId){
                    return elevatorController;
                }
            }
        }
        return elevatorControllerList.get(0);
    }
}
