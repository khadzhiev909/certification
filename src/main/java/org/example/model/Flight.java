package org.example.model;

import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    List<FlightSegment> segments;

    public Flight(List<FlightSegment> segs) {
        segments = segs;
    }

    public List<FlightSegment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
