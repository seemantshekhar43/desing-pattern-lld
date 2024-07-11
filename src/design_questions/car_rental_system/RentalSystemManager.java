package design_questions.car_rental_system;

import design_questions.car_rental_system.filters.LocationFilter;

import java.util.ArrayList;
import java.util.List;

public class RentalSystemManager {
    private final List<Store> stores;
    private final List<User> users;

    public RentalSystemManager() {
        this.stores = new ArrayList<>();
        this.users = new ArrayList<>();
    }


    public void addStore(Store store){
        this.stores.add(store);
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public List<Store> getStores() {
        return stores;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Store> getStores(List<Location> locationList) {
        LocationFilter locationFilter = new LocationFilter(locationList);
        return locationFilter.applyFilter(this.stores);
    }
}
