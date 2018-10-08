package parking;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(Parking... parkings) {
        super(parkings);
    }


    @Override
    public Ticket park(Car car) {
        Optional<Parking> optParkingList = parkingList.stream().sorted(Comparator.comparingDouble(Parking::calculateVacancyRate).reversed()).findFirst();
        Parking parking = null;
        if(optParkingList.isPresent()){
            parking = optParkingList.get();
        }
        return parking.park(car);
    }
}
