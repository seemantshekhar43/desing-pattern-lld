package design_questions.car_rental_system.price_computation_strategy;

import design_questions.car_rental_system.Reservation;
import design_questions.parking_lot.Ticket;

public interface PriceComputationStrategy {
    double computePrice(Reservation reservation);
}
