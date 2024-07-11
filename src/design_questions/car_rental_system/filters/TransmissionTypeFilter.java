package design_questions.car_rental_system.filters;

import design_questions.car_rental_system.TransmissionType;
import design_questions.car_rental_system.Vehicle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TransmissionTypeFilter implements VehicleFilter{
    private final Set<TransmissionType> transmissionTypes;

    public TransmissionTypeFilter(List<TransmissionType> transmissionTypes) {
        this.transmissionTypes = new HashSet<>(transmissionTypes);
    }

    @Override
    public List<Vehicle> applyFilter(List<Vehicle> vehicles) {
        return vehicles.stream().filter(vehicle -> transmissionTypes.contains(vehicle.getTransmissionType())).collect(Collectors.toList());
    }
}
