package design_questions.elevator_system;

import design_questions.elevator_system.button.InternalButton;
import design_questions.elevator_system.constants.ElevatorDirection;
import design_questions.elevator_system.constants.ElevatorStatus;
import design_questions.elevator_system.display.Display;
import design_questions.elevator_system.display.FloorDirectionObserver;

import java.util.ArrayList;
import java.util.List;

public class Elevator implements FloorDirectionSubject{
    private final int elevatorId;
    private int currentFloorId;
    private final InternalButton internalButton;
    private  final List<FloorDirectionObserver> observerList;
    private ElevatorDirection elevatorDirection;
    private ElevatorStatus elevatorStatus;


    public Elevator(int elevatorId, InternalButton internalButton) {
        this.elevatorId = elevatorId;
        this.currentFloorId = 1;
        this.internalButton = internalButton;
        this.elevatorDirection = ElevatorDirection.UP;
        this.elevatorStatus = ElevatorStatus.IDLE;
        this.observerList = new ArrayList<>();
    }

    public int getElevatorId() {
        return elevatorId;
    }

    synchronized public int getCurrentFloorId() {
        return currentFloorId;
    }

    public InternalButton getInternalButton() {
        return internalButton;
    }


    synchronized public ElevatorDirection getElevatorDirection() {
        return elevatorDirection;
    }

    public ElevatorStatus getElevatorStatus() {
        return elevatorStatus;
    }

    synchronized void setElevatorDirection(ElevatorDirection elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }

    public void setElevatorStatus(ElevatorStatus elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
        notifyListener();
    }

    private void setCurrentFloorId(int floorId){
        this.currentFloorId = floorId;
        notifyListener();
    }

    public void move(int floorId){
        setElevatorStatus(ElevatorStatus.MOVING);
        while(getCurrentFloorId() != floorId){
            try{
                Thread.sleep(2000);
                if(getElevatorDirection().equals(ElevatorDirection.UP)){
                    setCurrentFloorId(getCurrentFloorId() + 1);
                }else{
                    setCurrentFloorId(getCurrentFloorId() - 1);
                }
            }catch (Exception e){
                System.out.println("Thread exception");
            }


        }
        System.out.println("Elevator: " + elevatorId + " door opens at " + currentFloorId);
        setElevatorStatus(ElevatorStatus.IDLE);
    }

    @Override
    public void addObserver(FloorDirectionObserver floorDirectionObserver) {
        observerList.add(floorDirectionObserver);
    }

    @Override
    public void notifyListener() {
        for(FloorDirectionObserver observer : this.observerList){
            observer.update(this.elevatorId, this.currentFloorId, this.elevatorDirection, this.elevatorStatus);
        }
    }
}
