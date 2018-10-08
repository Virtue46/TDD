package parking;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    List<Parking> parkingList;

    private int totalCapacity;

    private int totalParkingCount;


    public ParkingBoy(Parking... parkings) {
        parkingList = Arrays.asList(parkings);
    }

    public Ticket park(Car car) {
        Optional<Parking> findFirst = parkingList.stream().filter(parking -> !parking.isFull()).findFirst();
        Parking firstParking = findFirst.get();
        return firstParking.park(car);
    }

    public Car pickup(Ticket ticket) {
        Optional<Parking> findFirst = parkingList.stream().filter(parking -> parking.count(ticket)).findFirst();
        return findFirst.get().pickup(ticket);

    }

    public String formatOutPut() {
        StringBuilder stringBuilder = new StringBuilder();
        String tempParking = null;

        for (Parking parking : parkingList
        ) {
            stringBuilder.append(parking.formatOutPut()).append(System.lineSeparator());
        }
        tempParking = stringBuilder.toString();


        return String.format("%s %s %s %s %s", "B", totalParkingCount, totalCapacity, System.lineSeparator(), tempParking);
    }

    public int getTotalCapacity() {

        for (Parking parking : parkingList
        ) {
            totalCapacity += parking.getCapacity();
        }
        return totalCapacity;
    }

    public int getTotalParkingCount() {
        for (Parking parking : parkingList
        ) {
            totalParkingCount += parking.getParkingCount();
        }
        return totalParkingCount;
    }
}
