package demo.calendar.request;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Request {

    LocalDate date();
    LocalTime from();
    LocalTime to();
    int requestedCapacity();

}
