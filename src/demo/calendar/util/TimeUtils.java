package demo.calendar.util;

import demo.calendar.unit.TimeUnit;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeUtils {

    static public boolean isWithinRange(LocalTime testDate, LocalTime from, LocalTime to) {
        return !(testDate.isBefore(from) || testDate.isAfter(to));
    }

    static public boolean isWithinRange(LocalDate testDate, LocalDate from, LocalDate to) {
        return !(testDate.isBefore(from) || testDate.isAfter(to));
    }

    static public boolean isTimeUnitInsideRange(TimeUnit unit, LocalTime from, LocalTime to) {
        return isWithinRange(unit.from(), from, to) && isWithinRange(unit.to(), from, to);
    }


}
