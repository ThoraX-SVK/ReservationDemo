package demo.calendar.unit;

import demo.calendar.request.RequestType;
import demo.calendar.util.TimeUtils;

import java.time.LocalTime;

public class DayPartTimeUnit implements TimeUnit {

    private LocalTime from;
    private LocalTime to;

    DayPartTimeUnit(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean supports(RequestType requestType) {
        return requestType == RequestType.TIME;
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
    public boolean isAvaiable(LocalTime requestedTime) {
        return TimeUtils.isWithinRange(requestedTime, this.from(), this.to());
    }
}
