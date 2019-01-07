package demo.calendar.unit;

import java.time.LocalTime;

public class WholeDayUnit implements Unit {

    private int currentCapacity;
    private int maxCapacity;

    WholeDayUnit(int currentCapacity, int maxCapacity) {
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
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
    public int capacity() {
        return currentCapacity;
    }

    @Override
    public int maxCapacity() {
        return maxCapacity;
    }
}
