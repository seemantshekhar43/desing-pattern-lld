package design_questions.parking_lot;

import design_questions.parking_lot.parking_manager.ParkingManager;
import design_questions.parking_lot.parking_manager.ParkingManagerFactory;
import design_questions.parking_lot.parking_spot.FourWheelerParkingSpot;
import design_questions.parking_lot.parking_spot.ParkingSpot;
import design_questions.parking_lot.parking_spot.TwoWheelerParkingSpot;
import design_questions.parking_lot.payment_method.CardPayment;
import design_questions.parking_lot.payment_method.PaymentStrategy;
import design_questions.parking_lot.payment_method.UPIPayment;
import design_questions.parking_lot.price_computation_strategy.HourlyPriceComputation;
import design_questions.parking_lot.price_computation_strategy.MinutesPriceComputation;
import design_questions.parking_lot.price_computation_strategy.PriceComputationStrategy;

public class Main {
    public static void main(String[] args) {
        Vehicle bike = new Vehicle("KA 01 B0 2345", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("TS 34 R7 8241", VehicleType.FOUR_WHEELER);

        ParkingSpot parkingSpot1 = new FourWheelerParkingSpot(1, 1);
        ParkingSpot parkingSpot2 = new FourWheelerParkingSpot(2, 3);
        ParkingSpot parkingSpot3 = new FourWheelerParkingSpot(3, 2);
        ParkingSpot parkingSpot4 = new TwoWheelerParkingSpot(4, 1);
        ParkingSpot parkingSpot5 = new TwoWheelerParkingSpot(5, 2);

        //Two wheeler Parking manager
        ParkingManager twoWheelerParkingManager = ParkingManagerFactory.getParkingManager(VehicleType.TWO_WHEELER);
        twoWheelerParkingManager.addParkingSpot(parkingSpot4);
        twoWheelerParkingManager.addParkingSpot(parkingSpot5);

        //Four wheeler Parking manager
        ParkingManager fourWheelerParkingManager = ParkingManagerFactory.getParkingManager(VehicleType.FOUR_WHEELER);
        fourWheelerParkingManager.addParkingSpot(parkingSpot1);
        fourWheelerParkingManager.addParkingSpot(parkingSpot2);
        fourWheelerParkingManager.addParkingSpot(parkingSpot3);

        //Park bike
        EntranceGate entranceGate1 = new EntranceGate(bike, twoWheelerParkingManager);
        Ticket bikeParkingTicket = entranceGate1.parkVehicle();

        //Park car
        EntranceGate entranceGate2 = new EntranceGate(car, fourWheelerParkingManager);
        Ticket carParkingTicket = entranceGate2.parkVehicle();

        //Exit bike
        PaymentStrategy upiPayment = new UPIPayment("abc@upi");
        PriceComputationStrategy hourly = new HourlyPriceComputation();
        ExitGate exitGate1 = new ExitGate(bikeParkingTicket, twoWheelerParkingManager, upiPayment, hourly);
        double parkingFee1 = exitGate1.computeCost();
        System.out.println("Parking fee calculated: " + parkingFee1);
        exitGate1.receivePayment();

        //Exit car
        PaymentStrategy cardPayment = new CardPayment("123345678905433", "dhoom");
        PriceComputationStrategy minutes = new MinutesPriceComputation();
        ExitGate exitGate2 = new ExitGate(carParkingTicket, fourWheelerParkingManager, cardPayment, minutes);
        double parkingFee2 = exitGate2.computeCost();
        System.out.println("Parking fee calculated: " + parkingFee2);
        exitGate2.receivePayment();

    }
}
