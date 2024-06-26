package design_questions.parking_lot;

import design_questions.parking_lot.parking_manager.ParkingManager;
import design_questions.parking_lot.parking_manager.ParkingManagerFactory;
import design_questions.parking_lot.parking_spot.ParkingSpot;

import java.time.LocalDateTime;

public class EntranceGate {
    private final ParkingManager parkingManager;
    private final Vehicle vehicle;

    public EntranceGate(Vehicle vehicle, ParkingManager parkingManager) {
        this.vehicle = vehicle;
        this.parkingManager = parkingManager;
    }

    private Ticket generateTicket(ParkingSpot parkingSpot){
        LocalDateTime currentTime = LocalDateTime.now();
        return  new Ticket(vehicle, currentTime, parkingSpot);
    }

    public Ticket parkVehicle(){
        ParkingSpot parkingSpot = this.parkingManager.findParkingSpace();
        System.out.println("Parking Spot Found: " + parkingSpot.toString());
        this.parkingManager.parkVehicle(vehicle, parkingSpot);
        System.out.println("Parked vehicle: " + this.vehicle.getVehicleNumber() + " of type: " + this.vehicle.getVehicleType() + " at parking id: " + parkingSpot.getId());
        Ticket ticket =  generateTicket(parkingSpot);
        System.out.println("Ticket generated for parking: " + ticket.toString());
        return ticket;
    }

    public ParkingSpot findParkingSpace(Vehicle vehicle){
        return this.parkingManager.findParkingSpace();
    }


}
