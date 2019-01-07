package demo.calendar.request;

import demo.calendar.unit.WholeDayUnit;

import java.time.LocalDate;
import java.time.LocalTime;

public class WholeDayRequest implements Request {

    private LocalDate date;
    private int requestedCapacity;

    WholeDayRequest(LocalDate date, int requestedCapacity) {
        this.date = date;
        this.requestedCapacity = requestedCapacity;
    }

    @Override
    public LocalDate date() {
        return date;
    }

    @Override
    public LocalTime from() {
        return LocalTime.MIN;
    }

    @Override
    public LocalTime to() {
        return LocalTime.MAX;
    }

    @Override
    public int requestedCapacity() {
        return requestedCapacity;
    }
}
