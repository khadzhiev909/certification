package org.example.filter;
import org.example.model.Flight;
import org.example.model.FlightSegment;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DepartureBeforeNowFilterTest {

    @Test
    public void testFilter_NoSegmentsDepartureBeforeNow() {
        // Arrange
        DepartureBeforeNowFilter filter = new DepartureBeforeNowFilter();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime futureDeparture = now.plusHours(1);
        Flight validFlight = new Flight(Arrays.asList(new FlightSegment(futureDeparture, futureDeparture.plusHours(1))));

        // Act
        List<Flight> result = filter.filter(Arrays.asList(validFlight));

        // Assert
        assertEquals(1, result.size());
        assertEquals(validFlight, result.get(0));
    }

    @Test
    public void testFilter_SegmentsDepartureBeforeNow() {
        // Arrange
        DepartureBeforeNowFilter filter = new DepartureBeforeNowFilter();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime pastDeparture = now.minusHours(1);
        Flight invalidFlight = new Flight(Arrays.asList(new FlightSegment(pastDeparture, pastDeparture.plusHours(1))));

        // Act
        List<Flight> result = filter.filter(Arrays.asList(invalidFlight));

        // Assert
        assertEquals(0, result.size());
    }
}
