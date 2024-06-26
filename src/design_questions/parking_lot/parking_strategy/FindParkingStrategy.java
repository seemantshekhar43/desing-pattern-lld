package design_questions.parking_lot.parking_strategy;

import design_questions.parking_lot.parking_spot.ParkingSpot;

import java.util.List;

public interface FindParkingStrategy {
    ParkingSpot finParkingSpot(List<ParkingSpot> parkingSpots);
}
