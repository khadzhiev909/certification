package org.example.filter;

import org.example.model.Flight;
import org.example.model.FlightSegment;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrivalBeforeDepartureFilterTest {

    @Test
    public void testFilter_NoSegmentsWithArrivalBeforeDeparture() {
        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();
        LocalDateTime departure = LocalDateTime.now();
        LocalDateTime arrival = departure.plusHours(2);
        Flight validFlight = new Flight(Arrays.asList(new FlightSegment(departure, arrival)));

        List<Flight> result = filter.filter(Arrays.asList(validFlight));

        assertEquals(1, result.size());
        assertEquals(validFlight, result.get(0));
    }

    @Test
    public void testFilter_SegmentsWithArrivalBeforeDeparture() {
        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();
        LocalDateTime departure = LocalDateTime.now();
        LocalDateTime arrivalBeforeDeparture = departure.minusHours(2);
        Flight invalidFlight = new Flight(Arrays.asList(new FlightSegment(departure, arrivalBeforeDeparture)));

        List<Flight> result = filter.filter(Arrays.asList(invalidFlight));

        assertEquals(0, result.size());
    }

    @Test
    public void testFilter_MultipleSegmentsWithArrivalBeforeDeparture() {
        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();
        LocalDateTime departure1 = LocalDateTime.now();
        LocalDateTime arrivalBeforeDeparture1 = departure1.minusHours(2);
        LocalDateTime departure2 = LocalDateTime.now().plusHours(1);
        LocalDateTime arrival2 = departure2.plusHours(2);
        Flight invalidFlight = new Flight(Arrays.asList(
                new FlightSegment(departure1, arrivalBeforeDeparture1),
                new FlightSegment(departure2, arrival2)
        ));

        List<Flight> result = filter.filter(Arrays.asList(invalidFlight));

        assertEquals(0, result.size());
    }
}
