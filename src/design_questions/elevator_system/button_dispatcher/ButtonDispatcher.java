package design_questions.elevator_system.button_dispatcher;

import java.util.List;

public interface ButtonDispatcher<T> {

     void submitRequest(int currentFloorId, T destination);


}
