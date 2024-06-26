package design_questions.parking_lot.price_computation_strategy;

import design_questions.parking_lot.Ticket;

public interface PriceComputationStrategy {
    double computePrice(Ticket ticket);
}
