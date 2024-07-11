package design_questions.car_rental_system;

import design_questions.car_rental_system.filters.VehicleFilter;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryManagement {
    private final List<Vehicle> vehicles;

    public VehicleInventoryManagement(List<Vehicle> vehicleList) {
        this.vehicles = vehicleList;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }

    public List<Vehicle> getVehicles(List<VehicleFilter> filters){
        List<Vehicle> availableVehicles = this.vehicles.stream().filter(Vehicle::isAvailable).toList();
        List<Vehicle> filteredList = new ArrayList<>(availableVehicles);
        for (VehicleFilter filter : filters) {
            filteredList = filter.applyFilter(filteredList);
        }
        return filteredList;
    }
}
