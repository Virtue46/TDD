package parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacancyRateTest {
    @Test
    void should_return_ticket_when_parking_one_car_to_Vacancy_Rate_is_maximum() {
        //given
        Parking parking1 = new Parking(3);
        Parking parking2 = new Parking(5);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parking1,parking2);
        //when
        parking1.park(new Car());
        parking2.park(new Car());
        Ticket ticket = parkingBoy.park(new Car());
        //then
        assertEquals(parking2.getParkingCount(), 2);



    }
}
