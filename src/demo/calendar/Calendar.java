package demo.calendar;

import demo.calendar.request.Request;
import demo.calendar.request.ReservationRequestWrapper;
import demo.calendar.unit.Unit;
import demo.calendar.unit.UnitNotFoundException;
import demo.calendar.util.CalendarUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

class Calendar {

    Map<LocalDate, List<Unit>> calendar;

    Calendar(LocalDate from, LocalDate to) {

    }

    public void tryToReserve(ReservationRequestWrapper request) throws UnitNotFoundException {

        for(Request subRequest : request.getSubrequests()) {
            Unit suitableUnits =  findSuitableUnits(subRequest);
        }
    }

    private Unit findSuitableUnits(Request request) throws UnitNotFoundException {
        List<Unit> units = calendar.get(request.date());

        return units.stream()
                .filter(unit -> CalendarUtils.areEqual(unit.from(), request.from()))
                .filter(unit -> CalendarUtils.areEqual(unit.to(), unit.to()))
                .filter(unit -> unit.isWithinCapacityLimit(request.requestedCapacity()))
                .findFirst()
                .orElseThrow(() -> new UnitNotFoundException("Could not find requested unit for request"));
    }
}