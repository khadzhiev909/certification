package org.example;

import org.example.model.Flight;
import org.example.model.FlightSegment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightBuilder {

    static List<Flight> createFlights() {
        //настоящее время + еще три дня
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                //A normal flight with two hour duration(Обычный полет продолжительностью два часа)
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                //A normal multi segment flight(Обычный многосегментный рейс)
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                //A flight departing in the past(Рейс, вылетающий в прошлом)
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                //A flight that departs before it arrives(Рейс, который вылетает до прибытия)
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                //A flight with more than two hours ground time(Рейс продолжительностью более двух часов наземного времени)
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                //Another flight with more than two hours ground time(Еще один рейс с наземным временем более двух часов.)
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
    }

    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "you must pass an even number of dates(вы должны передать четное количество дат)");
        }
        List<FlightSegment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new FlightSegment(dates[i], dates[i + 1]));
        }
        return new Flight(segments);
    }
}
