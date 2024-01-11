package org.example.filter;

import org.example.model.Flight;
import org.example.model.FlightSegment;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class GroundTimeExceedsTwoHoursFilter implements FlightFilter{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> calculateGroundTime(flight) <= 2 * 60) // в минутах
                .collect(Collectors.toList());
    }

    private long calculateGroundTime(Flight flight) {
        List<FlightSegment> segments = flight.getSegments();
        long groundTime = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            groundTime += Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toMinutes();
        }
        return groundTime;
    }
}
