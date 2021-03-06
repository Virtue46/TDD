package parking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingDirectorTest {
    @Test
    void should_generate_report() {
        //given
        Parking manageParking = new Parking(2);
        Parking boyParking = new Parking(3);
        ParkingBoy parkingBoy = new ParkingBoy(boyParking);
        List<ParkingBoy> parkBoyList = new ArrayList<ParkingBoy>();
        parkBoyList.add(parkingBoy);
        List<Parking> parkingList = new ArrayList<>();
        parkingList.add(manageParking);
        ParkingManager manager = new ParkingManager(parkingList, parkBoyList);
        ParkingDirector parkingDirector = new ParkingDirector(manager);

        //when
        Ticket ticket1 = manager.manageParkingBoyToPark(new Car());
        Ticket ticket2 = manager.park(new Car());


        //then
        String strMess = parkingDirector.viewReport();
        System.out.print(strMess);
        String strResult = "M 2 5 \n" +
                " P 1 2 \n" +
                "B 1 3 \n" +
                " P 1 3 \n\n";
        assertEquals(strMess, strResult);

    }


}
