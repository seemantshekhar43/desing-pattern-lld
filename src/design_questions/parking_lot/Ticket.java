package design_questions.parking_lot;

import design_questions.parking_lot.parking_spot.ParkingSpot;

import java.time.LocalDateTime;

public class Ticket {
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;

    public Ticket(Vehicle vehicle, LocalDateTime entryTime, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "vehicle=" + vehicle.getVehicleNumber() +
                ", entryTime=" + entryTime +
                ", parkingSpot=" + parkingSpot.getId() +
                '}';
    }
}
