package org.example.filter;

import org.example.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

/*Сегменты с датой прилёта раньше даты вылета:

Исключить перелеты, где хотя бы один сегмент имеет дату прилета раньше даты вылета.*/

public class ArrivalBeforeDepartureFilter implements FlightFilter{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
