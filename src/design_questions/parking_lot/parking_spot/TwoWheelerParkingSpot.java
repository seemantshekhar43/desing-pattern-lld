package design_questions.parking_lot.parking_spot;

public class TwoWheelerParkingSpot extends ParkingSpot{
    public TwoWheelerParkingSpot(int id, int floorNumber) {
        super(id, floorNumber);
    }

    @Override
    public double cost() {
        return 50.0;
    }
}
