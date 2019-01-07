package demo.calendar.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class PartalDayRequest implements Request {

    private LocalDate localDate;
    private LocalTime from;
    private LocalTime to;
    private int requestedCapacity;

    PartalDayRequest(LocalDate date, LocalTime from, LocalTime to, int requestedCapacity) {
        this.localDate = date;
        this.from = from;
        this.to = to;
        this.requestedCapacity = requestedCapacity;
    }

    @Override
    public LocalDate date() {
        return localDate;
    }

    @Override
    public LocalTime from() {
        return from;
    }

    @Override
    public LocalTime to() {
        return to;
    }

    @Override
    public int requestedCapacity() {
        return requestedCapacity;
    }
}
