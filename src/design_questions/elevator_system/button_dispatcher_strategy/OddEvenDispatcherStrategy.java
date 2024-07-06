package design_questions.elevator_system.button_dispatcher_strategy;

import design_questions.elevator_system.ElevatorController;
import design_questions.elevator_system.constants.ElevatorDirection;

import java.util.List;

public class OddEvenDispatcherStrategy implements DispatcherStrategy{

    @Override
    public ElevatorController findElevatorController(List<ElevatorController> elevatorControllerList, int currentFloorId, ElevatorDirection elevatorDirection) {
        if(elevatorControllerList.isEmpty()){
            throw new RuntimeException("No elevator found for: " + currentFloorId);
        }
        boolean isCurrentFloorIdEven = (currentFloorId % 2) == 0;
        for(ElevatorController elevatorController : elevatorControllerList){
            boolean isElevatorEven = (elevatorController.getElevatorId() % 2) == 0;
            if(isElevatorEven == isCurrentFloorIdEven){
                return elevatorController;
            }

        }
        return elevatorControllerList.get(0);
    }
}
