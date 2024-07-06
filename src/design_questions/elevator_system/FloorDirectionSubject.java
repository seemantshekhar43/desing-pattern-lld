package design_questions.elevator_system;

import design_questions.elevator_system.display.FloorDirectionObserver;

public interface FloorDirectionSubject {
    public void addObserver(FloorDirectionObserver floorDirectionObserver);
    public void notifyListener();
}
