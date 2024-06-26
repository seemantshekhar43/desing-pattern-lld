package design_questions.parking_lot.parking_manager;

import design_questions.parking_lot.parking_spot.ParkingSpot;
import design_questions.parking_lot.parking_strategy.FindParkingStrategy;

import java.util.List;

public class FourWheelerParkingManager extends ParkingManager{
    public FourWheelerParkingManager(List<ParkingSpot> parkingSpots, FindParkingStrategy findParkingStrategy) {
        super(parkingSpots, findParkingStrategy);
    }
}
