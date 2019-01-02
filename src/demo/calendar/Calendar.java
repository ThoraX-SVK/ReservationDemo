package demo.calendar;

import demo.calendar.request.Request;
import demo.calendar.request.RequestType;
import demo.calendar.request.TimeRequest;
import demo.calendar.unit.CalendarUnit;
import demo.calendar.unit.TimeUnit;
import demo.calendar.util.TimeUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Calendar {

    Map<LocalDate, List<CalendarUnit>> calendar;

    Calendar(LocalDate from, LocalDate to) {

    }

    public void tryToReserve(ReservationRequestWrapper request) {

        for(Request subRequest : request.getSubrequests()) {
            validateAndReserveUnits(subRequest);
        }
    }

    private void validateAndReserveUnits(Request request) {

        switch (request.getType()) {
            case TIME:
                validateAndReserveTimeUnits(request);
                break;
            case CAPACITY:
                validateCapacityRequest(request);
                break;
            default:
                break;
        }

    }

    private void validateAndReserveTimeUnits(Request request) {
        List<TimeUnit> possible = getTimeUnitsInsideRequestRange(request);
        reserveTimeUnits(possible);
    }

    private List<TimeUnit> getTimeUnitsInsideRequestRange(Request request) {
        TimeRequest timeRequest = (TimeRequest) request;

        List<CalendarUnit> allDayUnits = calendar.get(timeRequest.on());
        List<CalendarUnit> timeUnits = filterUnitsWithSupport(allDayUnits ,RequestType.TIME);

        return getUnitsInsideRange(timeUnits, timeRequest);
    }

    private List<CalendarUnit> filterUnitsWithSupport(List<CalendarUnit> units, RequestType requestType) {
        return units.stream()
                .filter(unit -> unit.supports(requestType))
                .collect(Collectors.toList());
    }

    private void reserveTimeUnits(List<TimeUnit> units) {
        units.forEach(unit -> unit.reserve());
    }

    private List<TimeUnit> getUnitsInsideRange(List<CalendarUnit> requestedDayUnits, TimeRequest timeRequest) {
        return requestedDayUnits.stream()
                .map(calendarUnit -> (TimeUnit) calendarUnit)
                .filter(timeUnit -> TimeUtils.isTimeUnitInsideRange(timeUnit, timeRequest.from(), timeRequest.to()))
                .collect(Collectors.toList());
    }
}