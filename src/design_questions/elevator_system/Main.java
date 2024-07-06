package design_questions.elevator_system;

import design_questions.elevator_system.button.ExternalButton;
import design_questions.elevator_system.button.ExternalDirectionButton;
import design_questions.elevator_system.button.ExternalNumericButton;
import design_questions.elevator_system.button.InternalButton;
import design_questions.elevator_system.button_dispatcher.ExternalDirectionButtonDispatcher;
import design_questions.elevator_system.button_dispatcher.ExternalNumericButtonDispatcher;
import design_questions.elevator_system.button_dispatcher.InternalButtonDispatcher;
import design_questions.elevator_system.button_dispatcher_strategy.IdleElevatorDispatcherStrategy;
import design_questions.elevator_system.button_dispatcher_strategy.OddEvenDispatcherStrategy;
import design_questions.elevator_system.button_dispatcher_strategy.SameDirectionDispatcherStrategy;
import design_questions.elevator_system.constants.ElevatorDirection;
import design_questions.elevator_system.display.Display;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Floor> floorList = new ArrayList<>();
        List<ElevatorController> elevatorControllerList = new ArrayList<>();
        int maxFloors = 5;

        Map<String, Integer> numericLabels= new HashMap<>();
        numericLabels.put("1", 1);
        numericLabels.put("2", 2);
        numericLabels.put("3", 3);
        numericLabels.put("4", 4);
        numericLabels.put("5", 5);

        Map<String, ElevatorDirection> directionLabels = new HashMap<>();
        directionLabels.put("UP", ElevatorDirection.UP);
        directionLabels.put("DOWN", ElevatorDirection.DOWN);

        //----------------------------- Internal Button ----------------------------------------------------------------------------------------------------------

        InternalButton internalButton1 = new InternalButton(numericLabels);
        InternalButton internalButton2 = new InternalButton(numericLabels);
        InternalButton internalButton3 = new InternalButton(numericLabels);

        //----------------------------- Elevator and ElevatorController ----------------------------------------------------------------------------------------------------------

        Elevator elevator1 = new Elevator(1, internalButton1);
        ElevatorController elevatorController1 = new ElevatorController(elevator1, maxFloors - 1);
        elevatorControllerList.add(elevatorController1);

        Elevator elevator2 = new Elevator(2, internalButton2);
        ElevatorController elevatorController2 = new ElevatorController(elevator2, maxFloors - 1);
        elevatorControllerList.add(elevatorController2);

        Elevator elevator3 = new Elevator(3, internalButton3);
        ElevatorController elevatorController3 = new ElevatorController(elevator3, maxFloors - 1);
        elevatorControllerList.add(elevatorController3);



        //----------------------------- Internal Button Dispatcher ----------------------------------------------------------------------------------------------------------

        InternalButtonDispatcher internalButtonDispatcher1 = new InternalButtonDispatcher(elevatorController1);
        InternalButtonDispatcher internalButtonDispatcher2 = new InternalButtonDispatcher(elevatorController2);
        InternalButtonDispatcher internalButtonDispatcher3 = new InternalButtonDispatcher(elevatorController3);

        internalButton1.setButtonDispatcher(internalButtonDispatcher1);
        internalButton2.setButtonDispatcher(internalButtonDispatcher2);
        internalButton3.setButtonDispatcher(internalButtonDispatcher3);

        //----------------------------- External Numeric Button ----------------------------------------------------------------------------------------------------------

        ExternalButton<Integer> externalNumericButton1 = new ExternalNumericButton(numericLabels, 1);
        ExternalButton<Integer> externalNumericButton2 = new ExternalNumericButton(numericLabels, 2);
        ExternalButton<Integer> externalNumericButton3 = new ExternalNumericButton(numericLabels, 3);
        ExternalButton<Integer> externalNumericButton4 = new ExternalNumericButton(numericLabels, 4);
        ExternalButton<Integer> externalNumericButton5 = new ExternalNumericButton(numericLabels, 5);

        ExternalNumericButtonDispatcher externalNumericButtonDispatcher1 = new ExternalNumericButtonDispatcher(elevatorControllerList, new IdleElevatorDispatcherStrategy());
        ExternalNumericButtonDispatcher externalNumericButtonDispatcher2 = new ExternalNumericButtonDispatcher(elevatorControllerList, new OddEvenDispatcherStrategy());
        ExternalNumericButtonDispatcher externalNumericButtonDispatcher3 = new ExternalNumericButtonDispatcher(elevatorControllerList, new SameDirectionDispatcherStrategy());
        ExternalNumericButtonDispatcher externalNumericButtonDispatcher4 = new ExternalNumericButtonDispatcher(elevatorControllerList, new SameDirectionDispatcherStrategy());
        ExternalNumericButtonDispatcher externalNumericButtonDispatcher5 = new ExternalNumericButtonDispatcher(elevatorControllerList, new IdleElevatorDispatcherStrategy());

        externalNumericButton1.setButtonDispatcher(externalNumericButtonDispatcher1);
        externalNumericButton2.setButtonDispatcher(externalNumericButtonDispatcher2);
        externalNumericButton3.setButtonDispatcher(externalNumericButtonDispatcher3);
        externalNumericButton4.setButtonDispatcher(externalNumericButtonDispatcher4);
        externalNumericButton5.setButtonDispatcher(externalNumericButtonDispatcher5);


        //----------------------------- External Direction  Button ----------------------------------------------------------------------------------------------------------

        ExternalButton<ElevatorDirection> externalDirectionButton1 = new ExternalDirectionButton(directionLabels, 1);
        ExternalButton<ElevatorDirection> externalDirectionButton2 = new ExternalDirectionButton(directionLabels, 2);
        ExternalButton<ElevatorDirection> externalDirectionButton3 = new ExternalDirectionButton(directionLabels, 3);
        ExternalButton<ElevatorDirection> externalDirectionButton4 = new ExternalDirectionButton(directionLabels, 4);
        ExternalButton<ElevatorDirection> externalDirectionButton5 = new ExternalDirectionButton(directionLabels, 5);

        ExternalDirectionButtonDispatcher externalDirectionButtonDispatcher1 = new ExternalDirectionButtonDispatcher(elevatorControllerList, new IdleElevatorDispatcherStrategy());
        ExternalDirectionButtonDispatcher externalDirectionButtonDispatcher2 = new ExternalDirectionButtonDispatcher(elevatorControllerList, new OddEvenDispatcherStrategy());
        ExternalDirectionButtonDispatcher externalDirectionButtonDispatcher3 = new ExternalDirectionButtonDispatcher(elevatorControllerList, new SameDirectionDispatcherStrategy());
        ExternalDirectionButtonDispatcher externalDirectionButtonDispatcher4 = new ExternalDirectionButtonDispatcher(elevatorControllerList, new SameDirectionDispatcherStrategy());
        ExternalDirectionButtonDispatcher externalDirectionButtonDispatcher5 = new ExternalDirectionButtonDispatcher(elevatorControllerList, new IdleElevatorDispatcherStrategy());

        externalDirectionButton1.setButtonDispatcher(externalDirectionButtonDispatcher1);
        externalDirectionButton2.setButtonDispatcher(externalDirectionButtonDispatcher2);
        externalDirectionButton3.setButtonDispatcher(externalDirectionButtonDispatcher3);
        externalDirectionButton4.setButtonDispatcher(externalDirectionButtonDispatcher4);
        externalDirectionButton5.setButtonDispatcher(externalDirectionButtonDispatcher5);


        //------------------------------ Internal Display --------------------------------------------------------------------------------------------------------------------

        Display internalDisplay1 = new Display("Internal 1");
        Display internalDisplay2 = new Display("Internal 2");
        Display internalDisplay3 = new Display("Internal 3");

        elevator1.addObserver(internalDisplay1);
        elevator2.addObserver(internalDisplay2);
        elevator3.addObserver(internalDisplay3);


        //------------------------------ External Display --------------------------------------------------------------------------------------------------------------------

        Display externalDisplay1 = new Display("External 1");
        Display externalDisplay2 = new Display("External 2");
        Display externalDisplay3 = new Display("External 3");
        Display externalDisplay4 = new Display("External 4");
        Display externalDisplay5 = new Display("External 5");

        elevator1.addObserver(externalDisplay1);
        elevator1.addObserver(externalDisplay2);
        elevator1.addObserver(externalDisplay3);
        elevator1.addObserver(externalDisplay4);
        elevator1.addObserver(externalDisplay5);

        elevator2.addObserver(externalDisplay1);
        elevator2.addObserver(externalDisplay2);
        elevator2.addObserver(externalDisplay3);
        elevator2.addObserver(externalDisplay4);
        elevator2.addObserver(externalDisplay5);

        elevator3.addObserver(externalDisplay1);
        elevator3.addObserver(externalDisplay2);
        elevator3.addObserver(externalDisplay3);
        elevator3.addObserver(externalDisplay4);
        elevator3.addObserver(externalDisplay5);


        //------------------------------ Floor ----------------------------------------------------------------------------------------------------------------------------------
        Floor floor1 = new Floor(1, externalDisplay1, externalNumericButton1, externalDirectionButton1);
        floorList.add(floor1);
        Floor floor2 = new Floor(2, externalDisplay2, externalNumericButton2, externalDirectionButton2);
        floorList.add(floor2);
        Floor floor3 = new Floor(3, externalDisplay3, externalNumericButton3, externalDirectionButton3);
        floorList.add(floor3);
        Floor floor4 = new Floor(4, externalDisplay4, externalNumericButton4, externalDirectionButton4);
        floorList.add(floor4);
        Floor floor5 = new Floor(5, externalDisplay5, externalNumericButton5, externalDirectionButton5);
        floorList.add(floor5);

        //-------------------------------Building-----------------------------------------------------------------------------------------------------------------------------------

        Building building = new Building(floorList, elevatorControllerList);


        //-------------------------------Requests-----------------------------------------------------------------------------------------------------------------------------------
        for (ElevatorController elevatorController :elevatorControllerList){
            Thread thread = new Thread(elevatorController::controlElevator);
            thread.start();
        }


//        floor1.getExternalDirectionButton().onPress("UP");
//        floor2.getExternalDirectionButton().onPress("DOWN");

        floor3.getExternalNumericButton().onPress("4");
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        floor5.getExternalNumericButton().onPress("1");
//
//        floor2.getExternalNumericButton().onPress("1");
//        floor1.getExternalNumericButton().onPress("4");

    }
}
