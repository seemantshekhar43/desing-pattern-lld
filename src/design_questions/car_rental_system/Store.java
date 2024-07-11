package design_questions.car_rental_system;


import design_questions.car_rental_system.filters.VehicleFilter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Store {
    private final String storeId;
    private final Location location;
    private final VehicleInventoryManagement vehicleInventoryManagement;
    private final List<Reservation> reservationList;

    public Store(Location location, VehicleInventoryManagement vehicleInventoryManagement) {
        this.storeId = UUID.randomUUID().toString();
        this.location = location;
        this.vehicleInventoryManagement = vehicleInventoryManagement;
        this.reservationList = new ArrayList<>();
    }

    public List<Vehicle> getVehicles(List<VehicleFilter> filters){
        return this.vehicleInventoryManagement.getVehicles(filters);
    }

    public List<Vehicle> getVehicles(){
        return this.vehicleInventoryManagement.getVehicles();
    }

    public Reservation reserveVehicle(Vehicle vehicle, User user, LocalDateTime startTime, LocalDateTime endTime, ReservationType reservationType){
        vehicle.updateAvailability(false);
        Reservation reservation = new Reservation(vehicle, this, user, startTime, endTime, reservationType);
        this.reservationList.add(reservation);
        user.addReservation(reservation);
        System.out.println("Reserved vehicle: " + vehicle.getVehicleModel() + " from: " + reservation.getStartTime() + " to: " + reservation.getEndTime() + ".");
        return reservation;
    }

    public void submitVehicle(Reservation reservation){
        reservation.updateReservationStatus(ReservationStatus.RETURNED);
        reservation.getVehicle().updateAvailability(true);
        this.reservationList.remove(reservation);
        reservation.getUser().getReservations().remove(reservation);
        System.out.println("Vehicle: " + reservation.getVehicle().getVehicleModel() + " submitted successfully!");
    }

    public void pickUpVehicle(Reservation reservation){
        if(!reservation.getBill().isPaid()){
            System.out.println("Bill not paid!");
        }else{
            reservation.updateReservationStatus(ReservationStatus.PICKED);
            System.out.println("Vehicle: " + reservation.getVehicle().getVehicleModel() + " picked up from store Id: "+ getStoreId()+ " successfully!");
        }
    }

    public String getStoreId() {
        return storeId;
    }

    public Location getLocation() {
        return location;
    }

    public VehicleInventoryManagement getVehicleInventoryManagement() {
        return vehicleInventoryManagement;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }
}