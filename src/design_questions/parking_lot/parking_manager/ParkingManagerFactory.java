package design_questions.parking_lot.parking_manager;

import design_questions.parking_lot.VehicleType;
import design_questions.parking_lot.parking_strategy.FourWheelerFindParking;
import design_questions.parking_lot.parking_strategy.TwoWheelerFindParking;

import java.util.ArrayList;

public class ParkingManagerFactory {

    public static ParkingManager getParkingManager(VehicleType vehicleType){
        if(vehicleType.equals(VehicleType.TWO_WHEELER)){
            return new TwoWheelerParkingManager(new ArrayList<>(), new TwoWheelerFindParking());
        }else if(vehicleType.equals(VehicleType.FOUR_WHEELER)){
            return new FourWheelerParkingManager(new ArrayList<>(), new FourWheelerFindParking());
        }
        throw new RuntimeException("Vehicle types does not exist.");
    }
}
