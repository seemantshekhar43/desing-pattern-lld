package design_questions.car_rental_system.price_computation_strategy;

import design_questions.car_rental_system.ReservationType;

public class PriceComputationStrategyFactory {
    public PriceComputationStrategy getPriceComputationStrategy(ReservationType reservationType){
        if(reservationType.equals(ReservationType.DAILY)){
            return new DailyPriceComputation();
        }else if(reservationType.equals(ReservationType.HOURLY)){
            return new HourlyPriceComputation();
        }

        throw new RuntimeException("Invalid Reservation type: " + reservationType);
    }
}
