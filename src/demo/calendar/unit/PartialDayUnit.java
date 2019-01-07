package demo.calendar.unit;

import java.time.LocalTime;

public class PartialDayUnit implements Unit {

    private LocalTime from;
    private LocalTime to;
    private int currentCapacity;
    private int maxCapacity;

    @Override
    public LocalTime from() {
        return from;
    }

    @Override
    public LocalTime to() {
        return to;
    }

    @Override
    public int capacity() {
        return currentCapacity;
    }

    @Override
    public int maxCapacity() {
        return maxCapacity;
    }
}
