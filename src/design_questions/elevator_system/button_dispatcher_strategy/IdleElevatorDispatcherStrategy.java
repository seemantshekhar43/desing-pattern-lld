package design_questions.elevator_system.button_dispatcher_strategy;


import design_questions.elevator_system.ElevatorController;
import design_questions.elevator_system.constants.ElevatorDirection;
import design_questions.elevator_system.constants.ElevatorStatus;

import java.util.List;

public class IdleElevatorDispatcherStrategy implements DispatcherStrategy{

    @Override
    public ElevatorController findElevatorController(List<ElevatorController> elevatorControllerList, int currentFloorId, ElevatorDirection elevatorDirection) {
        if(elevatorControllerList.isEmpty()){
            throw new RuntimeException("No elevator found for: " + currentFloorId);
        }

        for(ElevatorController elevatorController : elevatorControllerList){
            if(elevatorController.getElevatorStatus().equals(ElevatorStatus.IDLE)){
                return elevatorController;
            }
        }
        return elevatorControllerList.get(0);
    }
}