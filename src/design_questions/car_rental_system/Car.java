package design_questions.car_rental_system;

import java.time.LocalDate;

public class Car extends Vehicle{
    private final CarType carType;
    public Car(String vehicleNumber, String vehicleModel, TransmissionType transmissionType, FuelType fuelType, int seatingCapacity, double hourlyRentalPrice, double dailyRentalPrice, LocalDate manufacturedDate, double kmsDriven, boolean isAvailable, CarType carType) {
        super(vehicleNumber, VehicleType.CAR, vehicleModel, transmissionType, fuelType, seatingCapacity, hourlyRentalPrice, dailyRentalPrice, manufacturedDate, kmsDriven, isAvailable);
        this.carType = carType;
    }

    public CarType getCarType() {
        return carType;
    }
}
