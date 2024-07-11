package design_questions.car_rental_system;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private final String reservationId;
    private final Vehicle vehicle;
    private final Store store;
    private final User user;
    private final LocalDateTime reservationTime;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final ReservationType reservationType;
    private  ReservationStatus reservationStatus;
    private Bill bill;


    public Reservation(Vehicle vehicle, Store store, User user, LocalDateTime startTime, LocalDateTime endTime, ReservationType reservationType) {
        this.reservationId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.store = store;
        this.user = user;
        this.reservationTime = LocalDateTime.now();
        this.startTime = startTime;
        this.endTime = endTime;
        this.reservationType = reservationType;
        this.reservationStatus = ReservationStatus.RESERVED;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Store getStore() {
        return store;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public Bill generateBill(){
        this.bill = new Bill(this);
        System.out.println("Bill Generated for reservation ID: " + bill.getReservation().getReservationId() + ". Total amount to be paid is: " + bill.getAmount());
        return this.bill;
    }

    public void updateReservationStatus(ReservationStatus reservationStatus){
        this.reservationStatus = reservationStatus;
    }

    public User getUser() {
        return user;
    }
}
