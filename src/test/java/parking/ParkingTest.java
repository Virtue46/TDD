package parking;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingTest {


    @Test
    public void should_get_ticket_when_parking_one_car() throws Exception {
        // given
        Parking parking = new Parking(1);
        Car car = new Car();
        // when
        Ticket ticket = parking.park(car);
        // then
        assertNotNull(ticket);


    }

    @Test
    void should_throw_full_exception_when_parking_is_full() throws Exception {
        // given
        Parking parking = new Parking(1);
        Car car1 = new Car();
        Car car2 = new Car();
        // when
        parking.park(car1);
        // then
        assertThrows(IndexOutOfBoundsException.class, () -> parking.park(car2));

    }

    @Test
    void should_get_indicated_car_when_parking_ha_one_car() throws Exception {
        // given
        Parking parking = new Parking(1);
        Car car = new Car();
        Ticket ticket = parking.park(car);
        // when
        Car pickupCar = parking.pickup(ticket);
        // then
        assertEquals(car, pickupCar);
    }

    @Test
    void should_get_indicated_car_when_parking_ha_two_car() throws Exception {
        // given
        Parking parking = new Parking(2);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parking.park(car1);
        Ticket ticket2 = parking.park(car2);
        // when
        Car pickupCar = parking.pickup(ticket2);
        // then
        assertEquals(car2, pickupCar);
    }








}
