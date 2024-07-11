package design_questions.car_rental_system;

import design_questions.car_rental_system.filters.CarTypeFilter;
import design_questions.car_rental_system.filters.TransmissionTypeFilter;
import design_questions.car_rental_system.filters.VehicleFilter;
import design_questions.car_rental_system.payment_method.UPIPayment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        Car nexonCar  = new Car("KA 08 BV 2234", "Tata Nexon", TransmissionType.AUTOMATIC, FuelType.PETROL, 5, 200.0, 4500.0, LocalDate.now(), 300.0, true, CarType.HATCHBACK);
        Car xuvCar  = new Car("MH 10 BV 4367", "XUV 300", TransmissionType.MANUAL, FuelType.DIESEL, 5, 300.0, 6500.0, LocalDate.now(), 600.0, true, CarType.SUV);

        vehicleList.add(nexonCar);
        vehicleList.add(xuvCar);

        GeoLocation geoLocation = new GeoLocation("123.9876", "-98.234");
        Location location = new Location("Bengaluru", "Karnataka", "560200", geoLocation);

        VehicleInventoryManagement vehicleInventoryManagement = new VehicleInventoryManagement(vehicleList);

        Store store = new Store(location, vehicleInventoryManagement);


        User user = new User("Raman", "Kumar", "ramankumar@email.com", "9876543210");

        RentalSystemManager rentalSystemManager = new RentalSystemManager();
        rentalSystemManager.addStore(store);
        rentalSystemManager.addUser(user);

        // Let's say a user comes
        User customer = rentalSystemManager.getUsers().get(0);

        //Filters store based on location filter
        List<Store> filteredStores = rentalSystemManager.getStores(Collections.singletonList(new Location("Bengaluru", null, null, null)));
        Store selectedStore = filteredStores.get(0);

        //Add vehicle filters
        List<VehicleFilter> filterList = new ArrayList<>();
        filterList.add(new CarTypeFilter(Collections.singletonList(CarType.SUV)));
        filterList.add(new TransmissionTypeFilter(Collections.singletonList(TransmissionType.MANUAL)));

        //Filter vehicles from the store based on filters
        List<Vehicle> filteredVehicles = selectedStore.getVehicles(filterList);
        Vehicle selectedVehicle = filteredVehicles.get(0);

        //Reserves the selected vehicle
        Reservation reservation = selectedStore.reserveVehicle(selectedVehicle, customer, LocalDateTime.now(), LocalDateTime.now().plusHours(10), ReservationType.HOURLY);

        //Generate the bill
        Bill bill = reservation.generateBill();

        //Choose Payment method and pay the bill
        System.out.println("Is bill paid: " + bill.isPaid());
        Payment payment = new Payment(new UPIPayment("raman@upi"), bill);
        payment.payBill();

        //check total reservations in store
        System.out.println("Total active reservations in store: " + selectedStore.getReservationList().size());

        //Check availability status of selected vehicle
        System.out.println("Is selected vehicle available in store: " + selectedVehicle.isAvailable());

        // Check total reservation of user
        System.out.println("Total active reservation of user: " + customer.getReservations().size());

        //pickup vehicle
        System.out.println("Reservation status before picking up vehicle: " + reservation.getReservationStatus());
        selectedStore.pickUpVehicle(reservation);
        System.out.println("Reservation status after picking up vehicle: " + reservation.getReservationStatus());

        //Submit vehicle
        System.out.println("Reservation status before submitting vehicle: " + reservation.getReservationStatus());
        selectedStore.submitVehicle(reservation);
        System.out.println("Reservation status after submitting vehicle: " + reservation.getReservationStatus());

        //Check availability status of selected vehicle
        System.out.println("Is selected vehicle available in store: " + selectedVehicle.isAvailable());

        // Check total reservation of store
        System.out.println("Total active reservation in store: " + selectedStore.getReservationList().size());

        // Check total reservation of user
        System.out.println("Total active reservation of user: " + customer.getReservations().size());










    }
}
