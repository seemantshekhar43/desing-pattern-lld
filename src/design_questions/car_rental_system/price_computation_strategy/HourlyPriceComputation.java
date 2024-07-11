package design_questions.car_rental_system.price_computation_strategy;

import design_questions.car_rental_system.Reservation;
import design_questions.parking_lot.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPriceComputation implements PriceComputationStrategy {
    @Override
    public double computePrice(Reservation reservation) {
        double cost = reservation.getVehicle().getHourlyRentalPrice();
        LocalDateTime startTime = reservation.getStartTime();
        LocalDateTime endTime = reservation.getEndTime();
        Duration duration = Duration.between(startTime, endTime);
        long totalHours = duration.toHours();
        return totalHours * cost;
    }
}
