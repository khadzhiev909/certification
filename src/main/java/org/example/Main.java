package org.example;

import org.example.filter.ArrivalBeforeDepartureFilter;
import org.example.filter.DepartureBeforeNowFilter;
import org.example.filter.FlightFilter;
import org.example.filter.GroundTimeExceedsTwoHoursFilter;
import org.example.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        // Первое правило: вылет до текущего момента времени
        FlightFilter departureBeforeNowFilter = new DepartureBeforeNowFilter();
        List<Flight> result1 = departureBeforeNowFilter.filter(flights);
        System.out.println("Flights with departure before now: " + result1);

        // Второе правило: сегменты с датой прилёта раньше даты вылета
        FlightFilter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        List<Flight> result2 = arrivalBeforeDepartureFilter.filter(flights);
        System.out.println("Flights with segments arrival before departure: " + result2);

        // Третье правило: время на земле превышает два часа
        FlightFilter groundTimeExceedsTwoHoursFilter = new GroundTimeExceedsTwoHoursFilter();
        List<Flight> result3 = groundTimeExceedsTwoHoursFilter.filter(flights);
        System.out.println("Flights with ground time exceeds two hours: " + result3);

    }
}