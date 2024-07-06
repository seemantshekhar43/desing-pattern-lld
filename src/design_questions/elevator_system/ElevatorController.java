package design_questions.elevator_system;

import design_questions.elevator_system.constants.ElevatorDirection;
import design_questions.elevator_system.constants.ElevatorStatus;
import design_questions.elevator_system.utils.DirectionUtil;

import java.util.*;

public class ElevatorController {

    static class Request{
        int currentFloorId;
        int destinationFloorId;
        ElevatorDirection elevatorDirection;

        public Request(int currentFloorId, int destinationFloorId, ElevatorDirection elevatorDirection) {
            this.currentFloorId = currentFloorId;
            this.destinationFloorId = destinationFloorId;
            this.elevatorDirection = elevatorDirection;
        }
    }
    private final Elevator elevator;
    private final int maxFloors;
    private final Queue<Integer> upQueue;
    private final Queue<Integer> downQueue;
    private final Set<Integer> upSet;
    private final Set<Integer> downSet;
    private final Queue<Request> pendingQueue;

    public ElevatorController(Elevator elevator, int maxFloors) {
        this.elevator = elevator;
        this.upQueue = new PriorityQueue<>(Collections.reverseOrder());
        this.downQueue = new PriorityQueue<>();
        this.pendingQueue = new LinkedList<>();
        this.upSet = new HashSet<>();
        this.downSet = new HashSet<>();
        this.maxFloors = maxFloors;
    }

    public void acceptRequest(int currentFloorId, int destinationFloorId){
        ElevatorDirection elevatorDirection = DirectionUtil.getElevatorDirection(currentFloorId, destinationFloorId);

        if(destinationFloorId > maxFloors || destinationFloorId < 0){
            throw new RuntimeException("Invalid Request");
        }

        int elevatorCurrentFloorId = getElevatorCurrentFloorId();
        ElevatorDirection elevatorCurrentDirection = getElevatorDirection();
        if(elevatorCurrentDirection.equals(elevatorDirection)){
            if(elevatorDirection == ElevatorDirection.UP && elevatorCurrentFloorId < currentFloorId){
                addFloorInQueue(currentFloorId, elevatorDirection);
                addFloorInQueue(destinationFloorId, elevatorDirection);
            }else if(elevatorDirection == ElevatorDirection.DOWN && elevatorCurrentFloorId > currentFloorId){
                addFloorInQueue(currentFloorId, elevatorDirection);
                addFloorInQueue(destinationFloorId, elevatorDirection);
            }else{
                pendingQueue.add(new Request(currentFloorId, destinationFloorId, elevatorDirection));
            }
        }else{
            addFloorInQueue(currentFloorId, elevatorDirection);
            addFloorInQueue(destinationFloorId, elevatorDirection);
        }



    }

    public void acceptRequest(int currentFloorId, ElevatorDirection elevatorDirection){
        if(currentFloorId == maxFloors && elevatorDirection.equals(ElevatorDirection.UP)){
            throw new RuntimeException("Invalid Request");
        }
        if(currentFloorId == 0 && elevatorDirection.equals(ElevatorDirection.DOWN)){
            throw new RuntimeException("Invalid Request");
        }

        int elevatorCurrentFloorId = getElevatorCurrentFloorId();
        ElevatorDirection elevatorCurrentDirection = getElevatorDirection();
        if(elevatorCurrentDirection.equals(elevatorDirection)){
            if(elevatorDirection == ElevatorDirection.UP && elevatorCurrentFloorId < currentFloorId){
               addFloorInQueue(currentFloorId, elevatorDirection);
            }else if(elevatorDirection == ElevatorDirection.DOWN && elevatorCurrentFloorId > currentFloorId){
                addFloorInQueue(currentFloorId, elevatorDirection);
            }else{
                pendingQueue.add(new Request(currentFloorId, -1, elevatorDirection));
            }
        }else{
            addFloorInQueue(currentFloorId, elevatorDirection);
        }


    }
    public void acceptRequest(int destinationFloorId){
        if(destinationFloorId > maxFloors){
            throw new RuntimeException("Invalid Request");
        }
        int elevatorCurrentFloorId = getElevatorCurrentFloorId();
        ElevatorDirection elevatorCurrentDirection = getElevatorDirection();
        ElevatorDirection requestDirection = DirectionUtil.getElevatorDirection(elevatorCurrentFloorId, destinationFloorId);
        if(elevatorCurrentDirection == requestDirection){
            addFloorInQueue(destinationFloorId, requestDirection);
        }
        pendingQueue.add(new Request(-1, destinationFloorId, requestDirection));
    }

    private void addFloorInQueue(int floorId, ElevatorDirection elevatorDirection){
        Set<Integer> floorSet = elevatorDirection.equals(ElevatorDirection.UP) ? this.upSet : this.downSet;
        Queue<Integer> floorQueue= elevatorDirection.equals(ElevatorDirection.UP) ? this.upQueue : this.downQueue;

        if(!floorSet.contains(floorId)){
            floorSet.add(floorId);
            floorQueue.add(floorId);
        }
        System.out.println("added to: " +elevatorDirection + " " + floorQueue);
    }

    public void controlElevator(){
        System.out.println("Elevator controller started on thread: "+ Thread.currentThread().getName());
        while(true){
            ElevatorDirection currentDirection = getElevatorDirection();
            String requestId = UUID.randomUUID().toString();
            if(currentDirection.equals(ElevatorDirection.UP) && !upQueue.isEmpty()){
                int nextFloor = upQueue.remove();
                upSet.remove(nextFloor);
                System.out.println("Starting upQueue request: " + requestId);
                System.out.println(Thread.currentThread().getName());
                elevator.move(nextFloor);
                System.out.println("Completed upQueue request: " + requestId);

            }else if(currentDirection.equals(ElevatorDirection.DOWN) && !downQueue.isEmpty()){
                int nextFloor = downQueue.remove();
                downSet.remove(nextFloor);
                System.out.println("Starting downQueue request: " + requestId);
                elevator.move(nextFloor);
                System.out.println("Completed downQueue request: " + requestId);            }else{
                if(!pendingQueue.isEmpty() || !upQueue.isEmpty() || !downQueue.isEmpty()){

                    //before changing direction reach the maxFloor
                    if(getElevatorDirection().equals(ElevatorDirection.UP)  && !downQueue.isEmpty()){
                        if(downQueue.peek() > getElevatorCurrentFloorId()){
                            System.out.println("Reaching to next request up floor: " + requestId);
                            elevator.move(downQueue.peek());
                            System.out.println("Reached next request up floor: " + requestId);
                        }
                    } else if(getElevatorDirection().equals(ElevatorDirection.DOWN)  && !upQueue.isEmpty()){
                        if(upQueue.peek() < getElevatorCurrentFloorId()){
                            System.out.println("Reaching to next request down floor: " + requestId);
                            elevator.move(upQueue.peek());
                            System.out.println("Reached next request down floor: " + requestId);

                        }
                    }

                    //change direction
                    ElevatorDirection nextDirection = getElevatorDirection().equals(ElevatorDirection.UP) ? ElevatorDirection.DOWN : ElevatorDirection.UP;

                    //add pending requests
                    this.elevator.setElevatorDirection(nextDirection);
                    addPendingRequests();
                }
            }

        }
    }

    private void addPendingRequests(){
        while(!this.pendingQueue.isEmpty()){
            Request request = this.pendingQueue.remove();
            ElevatorDirection direction = request.elevatorDirection;
            int sourceFloorId = request.currentFloorId;
            int destinationFloorId = request.destinationFloorId;
            if(sourceFloorId != -1){
                addFloorInQueue(sourceFloorId, direction);
            }
            if(destinationFloorId != -1){
                addFloorInQueue(destinationFloorId, direction);
            }
        }
    }

    public int getElevatorId(){
        return this.elevator.getElevatorId();
    }

    public int getElevatorCurrentFloorId(){
        return this.elevator.getCurrentFloorId();
    }

    public ElevatorStatus getElevatorStatus(){
        return this.elevator.getElevatorStatus();
    }

    public ElevatorDirection getElevatorDirection(){
        return this.elevator.getElevatorDirection();
    }
}
