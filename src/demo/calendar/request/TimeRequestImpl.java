package demo.calendar.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeRequestImpl extends Request implements TimeRequest {

    private LocalDate on;
    private LocalTime from;
    private LocalTime to;

    TimeRequestImpl(LocalDate on, LocalTime from, LocalTime to) {
        this.on = on;
        this.from = from;
        this.to = to;
    }

    @Override
    public RequestType getType() {
        return RequestType.TIME;
    }

    @Override
    public LocalDate on() {
        return on;
    }

    @Override
    public LocalTime from() {
        return from;
    }

    @Override
    public LocalTime to() {
        return to;
    }
}
