package design_questions.parking_lot.parking_strategy;

import design_questions.parking_lot.parking_spot.ParkingSpot;

import java.util.List;

public class FourWheelerFindParking implements FindParkingStrategy{
    @Override
    public ParkingSpot finParkingSpot(List<ParkingSpot> parkingSpotList) {
        for(ParkingSpot parkingSpot : parkingSpotList){
            if(parkingSpot.isAvailable()){
                return parkingSpot;
            }
        }
        throw new RuntimeException("No Parking Spot available");
    }
}
