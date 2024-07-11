package design_questions.car_rental_system.price_computation_strategy;

import design_questions.car_rental_system.Reservation;

import java.time.Duration;
import java.time.LocalDateTime;

public class DailyPriceComputation implements PriceComputationStrategy {

        @Override
        public double computePrice(Reservation reservation) {
            double cost = reservation.getVehicle().getDailyRentalPrice();
            LocalDateTime startTime = reservation.getStartTime();
            LocalDateTime endTime = reservation.getEndTime();
            Duration duration = Duration.between(startTime, endTime);
            long totalDays = duration.toDays();
            return totalDays * cost;
        }
}
