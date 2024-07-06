package design_questions.elevator_system.button_dispatcher;

import design_questions.elevator_system.utils.DirectionUtil;
import design_questions.elevator_system.ElevatorController;
import design_questions.elevator_system.constants.ElevatorDirection;
import design_questions.elevator_system.button_dispatcher_strategy.DispatcherStrategy;

import java.util.List;

public class ExternalNumericButtonDispatcher implements ExternalButtonDispatcher<Integer>{
    private final List<ElevatorController> elevatorControllerList;
    private final DispatcherStrategy dispatcherStrategy;

    public ExternalNumericButtonDispatcher(List<ElevatorController> elevatorControllerList, DispatcherStrategy dispatcherStrategy) {
        this.elevatorControllerList = elevatorControllerList;
        this.dispatcherStrategy = dispatcherStrategy;
    }
    @Override
    public void submitRequest(int currentFloorId, Integer destination) {
        int destinationFloorId = destination;
        ElevatorDirection direction = DirectionUtil.getElevatorDirection(currentFloorId, destinationFloorId);
        ElevatorController elevatorController = getElevatorController(currentFloorId, direction);
        elevatorController.acceptRequest(currentFloorId, destinationFloorId);
    }
    @Override
    public ElevatorController getElevatorController(int currentFloorId, ElevatorDirection elevatorDirection){
        return this.dispatcherStrategy.findElevatorController(this.elevatorControllerList, currentFloorId, elevatorDirection);
    }
}
