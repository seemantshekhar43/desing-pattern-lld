package design_questions.car_rental_system.filters;

import design_questions.car_rental_system.Vehicle;
import design_questions.car_rental_system.VehicleType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VehicleTypeFilter implements VehicleFilter{
    private final Set<VehicleType> vehicleTypes;


    public VehicleTypeFilter(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = new HashSet<>(vehicleTypes);
    }

    @Override
    public List<Vehicle> applyFilter(List<Vehicle> vehicles) {
        return vehicles.stream().filter(vehicle -> vehicleTypes.contains(vehicle.getVehicleType())).collect(Collectors.toList());
    }
}
