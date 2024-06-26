package design_questions.parking_lot.cost_computation;

import design_questions.parking_lot.Ticket;
import design_questions.parking_lot.price_computation_strategy.PriceComputationStrategy;

public abstract class CostComputation {
    PriceComputationStrategy priceComputationStrategy;

    public CostComputation(PriceComputationStrategy priceComputationStrategy) {
        this.priceComputationStrategy = priceComputationStrategy;
    }

    public abstract double computePrice(Ticket ticket);
}
