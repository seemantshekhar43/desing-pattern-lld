package design_questions.parking_lot.price_computation_strategy;

import design_questions.parking_lot.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPriceComputation implements PriceComputationStrategy{
    @Override
    public double computePrice(Ticket ticket) {
        double cost = ticket.getParkingSpot().cost();
        LocalDateTime startTime = ticket.getEntryTime();
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);
        long totalHours = duration.toHours();
        return totalHours * cost;
    }
}
