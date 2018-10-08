package parking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TwoParkingTest {


    @Test
    void should_park_first_parking_when_first_is_not_full() {

        Parking parking1 = new Parking(1);
        Parking parking2 = new Parking(1);
        ParkingBoy parkingBoy = new ParkingBoy(parking1,parking2);
        parkingBoy.park(new Car());
        assertEquals(parking1.isFull(),true);
        assertEquals(parking2.isFull(),false);



    }



    @Test
    void should_park_second_parking_when_first_is_full() {
        //given
        Parking parking1 = new Parking(1);
        Parking parking2 = new Parking(1);
        ParkingBoy parkingBoy = new ParkingBoy(parking1,parking2);
        // when
        Car car1 = new Car();
        Car car2 = new Car();
        parkingBoy.park(car1);
        parkingBoy.park(car2);

        //then
        assertEquals(parking2.isFull(),true);
    }


    @Test
    void should_throw_exception_when_all_parking_is_full() {
        //given
        Parking parking1 = new Parking(1);
        Parking parking2 = new Parking(1);
        ParkingBoy parkingBoy = new ParkingBoy(parking1,parking2);
        // when
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingBoy.park(car1);
        parkingBoy.park(car2);
        // then
        assertThrows(IndexOutOfBoundsException.class, () -> parkingBoy.park(car3));

    }


    @Test
    void should_get_car_from_parking_when_have_ticket() {
        //given
        Parking parking1 = new Parking(1);
        Parking parking2 = new Parking(1);
        ParkingBoy parkingBoy = new ParkingBoy(parking1,parking2);
        // when
        Ticket ticket = parkingBoy.park(new Car());
        parkingBoy.pickup(ticket);

    }
}
