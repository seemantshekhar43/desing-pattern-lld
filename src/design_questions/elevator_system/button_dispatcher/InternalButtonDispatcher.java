package design_questions.elevator_system.button_dispatcher;

import design_questions.elevator_system.ElevatorController;

import java.util.ArrayList;
import java.util.List;

public class InternalButtonDispatcher implements ButtonDispatcher<Integer>{

    private ElevatorController elevatorController;

    public InternalButtonDispatcher(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }
    public void submitRequest(int currentFloorId, Integer destination) {
        int destinationFloorId = destination;
        this.elevatorController.acceptRequest(destinationFloorId);
    }






}
