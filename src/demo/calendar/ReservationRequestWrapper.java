package demo.calendar;

import demo.calendar.request.Request;

import java.util.List;

public class ReservationRequestWrapper {

    private List<Request> requests;

    ReservationRequestWrapper(List<Request> requests) {
        this.requests = requests;
    }

     public List<Request> getSubrequests() {
        return this.requests;
    }

}
