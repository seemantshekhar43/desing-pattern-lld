package design_questions.car_rental_system.filters;

import design_questions.car_rental_system.Car;
import design_questions.car_rental_system.CarType;
import design_questions.car_rental_system.Vehicle;
import design_questions.car_rental_system.VehicleType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarTypeFilter implements VehicleFilter{

    private final Set<CarType> carTypes;

    public CarTypeFilter(List<CarType> carTypes) {
        this.carTypes = new HashSet<>(carTypes);
    }

    @Override
    public List<Vehicle> applyFilter(List<Vehicle> vehicles) {
        return vehicles.stream().filter(vehicle -> vehicle.getVehicleType().equals(VehicleType.CAR) && carTypes.contains(((Car)vehicle).getCarType())).collect(Collectors.toList());
    }
}

