package parking;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParkingManager {
    List<Parking> parkingList;
    List<ParkingBoy> parkingBoyList;

    private int totalCapacity;

    private int totalParkingCount;


    public ParkingManager(Parking... parkings) {
        parkingList = Arrays.asList(parkings);
    }

    public ParkingManager(ParkingBoy... parkingBoys) {
        this.parkingBoyList = Arrays.asList(parkingBoys);
    }

    public ParkingManager(List<Parking> parkingList, List<ParkingBoy> parkingBoyList) {
        this.parkingList = parkingList;
        this.parkingBoyList = parkingBoyList;
    }


    public Ticket park(Car car) {
        Optional<Parking> parkingLists = parkingList.stream().filter(parking -> !parking.isFull()).findFirst();
        Ticket ticket = parkingLists.get().park(car);
        return ticket;
    }


    public Ticket manageParkingBoyToPark(Car car) {
        Optional<ParkingBoy> parkingBoys = parkingBoyList.stream().findFirst();
        ParkingBoy parkingBoy = parkingBoys.get();
        Ticket ticket = parkingBoy.park(car);
        return ticket;
    }

    public Car pickUp(Ticket ticket) {
        Optional<Parking> parkings = parkingList.stream().filter(parking -> parking.count(ticket)).findFirst();
        Car car = parkings.get().pickup(ticket);
        return car;
    }

    public Car manageParkingBoyToPickUp(Ticket ticket) {
        Optional<ParkingBoy> parkingBoys = parkingBoyList.stream().findFirst();
        ParkingBoy parkingBoy = parkingBoys.get();
        return parkingBoy.pickup(ticket);
    }

    public List<Parking> getParkingList() {
        return parkingList;
    }

    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }


    public String generateReport() {
        StringBuilder returnStr = new StringBuilder();

        List<Parking> parkingList = this.getParkingList();
        List<ParkingBoy> parkingBoyList = this.getParkingBoyList();
        for (Parking parking : parkingList
        ) {
            totalCapacity += parking.getCapacity();
            totalParkingCount += parking.getParkingCount();
            returnStr.append(parking.formatOutPut());
        }

        for (ParkingBoy parkBoy : parkingBoyList
        ) {

            totalCapacity += parkBoy.getTotalCapacity();
            totalParkingCount += parkBoy.getTotalParkingCount();
            returnStr.append(parkBoy.formatOutPut());
        }

        String tempReturn = returnStr.toString();
        String tempManage = String.format("%s %s %s %s","M",totalParkingCount,totalCapacity,System.lineSeparator());
        return String.format("%s %s",tempManage,tempReturn);

    }


}
