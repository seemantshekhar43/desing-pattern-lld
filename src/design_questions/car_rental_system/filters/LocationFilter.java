package design_questions.car_rental_system.filters;

import design_questions.car_rental_system.Location;
import design_questions.car_rental_system.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LocationFilter {

    private final List<Location> locationList;

    public LocationFilter(List<Location> locationList) {
        this.locationList = new ArrayList<>(locationList);
    }

    public List<Store> applyFilter(List<Store> storeList){
        return storeList.stream().filter(store -> locationList.contains(store.getLocation())).collect(Collectors.toList());
    }
}
