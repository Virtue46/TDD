package parking;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Parking {


    private int capacity;


    private Map<Ticket, Car> ticketMap = new HashMap<>();


    public Parking(int capacity) {
        this.capacity = capacity;

    }


    public Ticket park(Car car) {
        if (ticketMap.size() >= capacity) {
            throw new IndexOutOfBoundsException("车位已满！");
        }
        Ticket ticket = new Ticket();
        ticketMap.put(ticket, car);
        return ticket;
    }


    public Car pickup(Ticket ticket) {
        return ticketMap.remove(ticket);
    }

    public boolean isFull() {
        return ticketMap.size() == capacity;
    }


    public boolean count(Ticket ticket) {
        return ticketMap.containsKey(ticket);
    }

    public int getParkingCount() {
        return this.ticketMap.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public String formatOutPut() {
        return String.format("%s %s %s %s", "P", this.getParkingCount(), this.getCapacity(), "\n").toString();
    }

    public Double calculateVacancyRate() {
        return (capacity - ticketMap.size()) * 1.0 / capacity;
    }
}
