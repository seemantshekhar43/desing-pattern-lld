package design_questions.car_rental_system.filters;

import design_questions.car_rental_system.Vehicle;

import java.util.List;
@FunctionalInterface
public interface VehicleFilter {
    List<Vehicle> applyFilter(List<Vehicle> vehicles);
}
