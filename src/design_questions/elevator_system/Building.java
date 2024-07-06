package design_questions.elevator_system;

import java.util.List;

public class Building {

    private final List<Floor> floors;
    private final List<ElevatorController> elevatorControllerList;


    public Building(List<Floor> floors, List<ElevatorController> elevatorControllerList) {
        this.floors = floors;
        this.elevatorControllerList = elevatorControllerList;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<ElevatorController> getElevatorControllers() {
        return elevatorControllerList;
    }

    public void addElevatorController(ElevatorController elevatorController){
        this.elevatorControllerList.add(elevatorController);
    }

    public void addFloor(Floor floor){
        this.floors.add(floor);
    }

}
