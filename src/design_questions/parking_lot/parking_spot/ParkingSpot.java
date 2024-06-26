package design_questions.parking_lot.parking_spot;

import design_questions.parking_lot.Vehicle;

public abstract class ParkingSpot {
    private int id;
    private int floorNumber;
    private boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSpot(int id, int floorNumber) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.isAvailable = true;
    }

    public abstract double cost();

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getId() {
        return id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
