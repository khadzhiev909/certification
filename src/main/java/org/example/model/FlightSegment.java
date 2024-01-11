package org.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightSegment {

    //дата вылета
    private final LocalDateTime departureDate;

    //дата прилета
    private final LocalDateTime arrivalDate;

    public FlightSegment(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}
