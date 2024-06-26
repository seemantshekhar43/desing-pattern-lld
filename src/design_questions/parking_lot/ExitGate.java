package design_questions.parking_lot;

import design_questions.parking_lot.cost_computation.CostComputation;
import design_questions.parking_lot.cost_computation.CostComputationFactory;
import design_questions.parking_lot.parking_manager.ParkingManager;
import design_questions.parking_lot.parking_manager.ParkingManagerFactory;
import design_questions.parking_lot.parking_spot.ParkingSpot;
import design_questions.parking_lot.payment_method.PaymentStrategy;
import design_questions.parking_lot.price_computation_strategy.PriceComputationStrategy;

public class ExitGate {

    private final ParkingManager parkingManager;
    private final PaymentStrategy paymentStrategy;
    private final CostComputation costComputation;
    private final Ticket ticket;

    private double parkingFee;

    public ExitGate(Ticket ticket, ParkingManager parkingManager, PaymentStrategy paymentStrategy, PriceComputationStrategy priceComputationStrategy) {
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        this.ticket = ticket;
        this.parkingManager = parkingManager;
        this.paymentStrategy = paymentStrategy;
        this.costComputation = CostComputationFactory.getCostComputation(vehicleType, priceComputationStrategy);
        this.parkingFee = 0.0;
    }

    public double computeCost(){
        this.parkingFee = this.costComputation.computePrice(this.ticket);
        return parkingFee;
    }

    public void receivePayment(){
        paymentStrategy.pay(this.parkingFee);
        removeVehicle();
    }

    public void removeVehicle(){
        ParkingSpot parkingSpot = this.ticket.getParkingSpot();
        this.parkingManager.removeVehicle(parkingSpot);
        System.out.println("Vehicle removed from spot: " + parkingSpot.getId());
    }


}
