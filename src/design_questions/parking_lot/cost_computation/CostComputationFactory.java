package design_questions.parking_lot.cost_computation;

import design_questions.parking_lot.VehicleType;
import design_questions.parking_lot.price_computation_strategy.PriceComputationStrategy;

public class CostComputationFactory {

    public static CostComputation getCostComputation(VehicleType vehicleType, PriceComputationStrategy priceComputationStrategy){
        if(vehicleType.equals(VehicleType.TWO_WHEELER)){
            return new TwoWheelerCostComputation(priceComputationStrategy);
        }else if(vehicleType.equals(VehicleType.FOUR_WHEELER)){
            return new FourWheelerCostComputation(priceComputationStrategy);
        }
        throw new RuntimeException("Vehicle types does not exist.");
    }
}
