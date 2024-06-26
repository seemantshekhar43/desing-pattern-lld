package design_questions.parking_lot.parking_manager;

import design_questions.parking_lot.Vehicle;
import design_questions.parking_lot.parking_spot.ParkingSpot;
import design_questions.parking_lot.parking_strategy.FindParkingStrategy;

import java.util.List;

public abstract class ParkingManager {
    private final List<ParkingSpot> parkingSpots;
    private final FindParkingStrategy findParkingStrategy;

    public ParkingManager(List<ParkingSpot> parkingSpots, FindParkingStrategy findParkingStrategy) {
        this.findParkingStrategy = findParkingStrategy;
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot findParkingSpace(){
        return this.findParkingStrategy.finParkingSpot(this.parkingSpots);
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        this.parkingSpots.add(parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.remove(parkingSpot);
    }

    public void parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpot.setVehicle(vehicle);
        parkingSpot.setAvailable(false);
    }

    public void removeVehicle(ParkingSpot parkingSpot){
        parkingSpot.setVehicle(null);
        parkingSpot.setAvailable(true);
    }

}
