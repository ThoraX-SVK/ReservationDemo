package demo.calendar.request;

import java.time.LocalDate;
import java.time.LocalTime;

public interface TimeRequest {

    LocalDate on();

    LocalTime from();

    LocalTime to();
}
