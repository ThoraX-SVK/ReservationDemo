package demo.calendar.unit;

import java.time.LocalTime;

public interface TimeUnit extends CalendarUnit {

    LocalTime from();

    LocalTime to();
}
