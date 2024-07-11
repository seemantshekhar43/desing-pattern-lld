package design_questions.car_rental_system;

import java.util.Objects;

public class Location {
    private final String city;
    private final String State;
    private final String pinCode;
    private final GeoLocation geoLocation;

    public Location(String city, String state, String pinCode, GeoLocation geoLocation) {
        this.city = city;
        State = state;
        this.pinCode = pinCode;
        this.geoLocation = geoLocation;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return State;
    }

    public String getPinCode() {
        return pinCode;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Location location = (Location) object;
        return Objects.equals(city, location.city) || Objects.equals(State, location.State) || Objects.equals(pinCode, location.pinCode) || Objects.equals(geoLocation, location.geoLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, State, pinCode, geoLocation);
    }
}
