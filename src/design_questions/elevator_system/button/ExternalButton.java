package design_questions.elevator_system.button;

import java.util.Map;

public abstract class ExternalButton<T> extends Button<T>{

    public int getCurrentFloorId() {
        return currentFloorId;
    }

    private final int currentFloorId;
    public ExternalButton(Map<String, T> labels, int currentFloorId) {
        super(labels);
        this.currentFloorId = currentFloorId;
    }

}
