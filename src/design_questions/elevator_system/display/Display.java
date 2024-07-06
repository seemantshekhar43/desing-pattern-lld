package design_questions.elevator_system.display;

import design_questions.elevator_system.constants.ElevatorDirection;
import design_questions.elevator_system.constants.ElevatorStatus;

public class Display implements FloorDirectionObserver{
    private String id;
    private int floorNumber;
    private ElevatorDirection elevatorDirection;
    private ElevatorStatus elevatorStatus;

    public Display(String id) {
        this.id = id;
    }

    @Override
    public void update(int elevatorId, int currentFloorNumber, ElevatorDirection currentDirection, ElevatorStatus elevatorStatus){
        this.floorNumber = currentFloorNumber;
        this.elevatorDirection = currentDirection;
        this.elevatorStatus = elevatorStatus;
        show(elevatorId);
    }

    public void show(int elevatorId){
        if(this.elevatorStatus == ElevatorStatus.MOVING){
            System.out.println("Display ID: " + id +" | Current floor is: " + floorNumber + " | Elevator: " + elevatorId + " is going: " + elevatorDirection);
        }else{
            System.out.println("Display ID: " + id +" | Current floor is: " + floorNumber);
        }

    }
}
