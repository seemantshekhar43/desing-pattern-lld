package design_questions.car_rental_system.filters;

import design_questions.car_rental_system.FuelType;
import design_questions.car_rental_system.Vehicle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FuelTypeFilter implements VehicleFilter{

    private final Set<FuelType> fuelTypes;

    public FuelTypeFilter(List<FuelType> fuelTypes) {
        this.fuelTypes = new HashSet<>(fuelTypes);
    }

    @Override
    public List<Vehicle> applyFilter(List<Vehicle> vehicles) {
        return vehicles.stream().filter(vehicle -> fuelTypes.contains(vehicle.getFuelType())).collect(Collectors.toList());
    }
}
