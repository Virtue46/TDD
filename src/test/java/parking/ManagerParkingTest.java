package parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ManagerParkingTest {

    @Test
    void should_get_ticket_when_parking_manager_park_one_car() {

        //given
        Parking parking = new Parking(1);
        ParkingManager parkingManager = new ParkingManager(parking);
        //when
        Ticket ticket = parkingManager.park(new Car());
        //then
        assertNotNull(ticket);

    }

    @Test
    void should_get_ticket_when_manager_manage_one_parking_boy_parking_one_car() {
        //given
        Parking parking = new Parking(1);
        ParkingManager parkingManager = new ParkingManager(new ParkingBoy(parking));
        //when
        Ticket ticket = parkingManager.manageParkingBoyToPark(new Car());
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_get_car_from_his_own_parking_when_manager_have_a_ticket() {

        //given
        Parking parking = new Parking(1);
        ParkingManager parkingManager = new ParkingManager(parking);
        //when
        Ticket ticket = parkingManager.park(new Car());
        Car car = parkingManager.pickUp(ticket);
        //then
        assertNotNull(car);
    }

    @Test
    void should_get_car_when_manager_manage_parking_boy_pik_up_car() {
        //given
        Parking parking = new Parking(1);
        ParkingManager parkingManager = new ParkingManager(new ParkingBoy(parking));
        //when
        Ticket ticket = parkingManager.manageParkingBoyToPark(new Car());
        Car car = parkingManager.manageParkingBoyToPickUp(ticket);
        //when
        assertNotNull(car);
    }
}
