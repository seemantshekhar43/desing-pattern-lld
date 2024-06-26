package design_questions.parking_lot.parking_spot;

public class FourWheelerParkingSpot extends ParkingSpot{
    public FourWheelerParkingSpot(int id, int floorNumber) {
        super(id, floorNumber);
    }

    @Override
    public double cost() {
        return 100.0;
    }
}
