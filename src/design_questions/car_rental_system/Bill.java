package design_questions.car_rental_system;


import design_questions.car_rental_system.price_computation_strategy.PriceComputationStrategy;
import design_questions.car_rental_system.price_computation_strategy.PriceComputationStrategyFactory;

import java.util.Random;
import java.util.UUID;

public class Bill {
    private final String billId;
    private final Reservation reservation;
    private boolean isPaid;
    private final double amount;


    public Bill(Reservation reservation) {
        this.billId = UUID.randomUUID().toString();
        this.reservation = reservation;
        this.isPaid = false;
        this.amount =computeRental();
    }

    private double computeRental(){
        ReservationType reservationType = this.reservation.getReservationType();
        PriceComputationStrategyFactory priceComputationStrategyFactory = new PriceComputationStrategyFactory();
        PriceComputationStrategy priceComputationStrategy = priceComputationStrategyFactory.getPriceComputationStrategy(reservationType);
        return priceComputationStrategy.computePrice(this.reservation);
    }

    public void updateBillStatus(boolean status){
        this.isPaid = status;
    }

    public String getBillId() {
        return billId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public double getAmount() {
        return amount;
    }
}
