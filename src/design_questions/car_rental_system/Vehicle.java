package design_questions.car_rental_system;

import java.time.LocalDate;

public abstract class Vehicle {
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private final String vehicleModel;
    private final TransmissionType transmissionType;
    private final FuelType fuelType;
    private final int seatingCapacity;
    private final double hourlyRentalPrice;
    private final double dailyRentalPrice;
    private final LocalDate manufacturedDate;
    private final double kmsDriven;
    private boolean isAvailable;


    public Vehicle(String vehicleNumber, VehicleType vehicleType, String vehicleModel, TransmissionType transmissionType, FuelType fuelType, int seatingCapacity, double hourlyRentalPrice, double dailyRentalPrice, LocalDate manufacturedDate, double kmsDriven, boolean isAvailable) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
        this.seatingCapacity = seatingCapacity;
        this.hourlyRentalPrice = hourlyRentalPrice;
        this.dailyRentalPrice = dailyRentalPrice;
        this.manufacturedDate = manufacturedDate;
        this.kmsDriven = kmsDriven;
        this.isAvailable = isAvailable;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public double getHourlyRentalPrice() {
        return hourlyRentalPrice;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public LocalDate getManufacturedDate() {
        return manufacturedDate;
    }

    public double getKmsDriven() {
        return kmsDriven;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void updateAvailability(boolean status){
        this.isAvailable = status;
    }
}
