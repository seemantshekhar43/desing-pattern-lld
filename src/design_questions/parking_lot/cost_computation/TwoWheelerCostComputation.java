package design_questions.parking_lot.cost_computation;

import design_questions.parking_lot.Ticket;
import design_questions.parking_lot.price_computation_strategy.PriceComputationStrategy;

public class TwoWheelerCostComputation extends CostComputation{
    public TwoWheelerCostComputation(PriceComputationStrategy priceComputationStrategy) {
        super(priceComputationStrategy);
    }

    @Override
    public double computePrice(Ticket ticket) {
        return priceComputationStrategy.computePrice(ticket);
    }
}
