package demo.calendar.unit;

import java.time.LocalTime;

public interface Unit {

     LocalTime from();
     LocalTime to();
     int capacity();
     int maxCapacity();

     default boolean isWithinCapacityLimit(int requested) {
          return requested + capacity() <= maxCapacity();
     }
}
