package org.example.filter;

import org.example.model.Flight;
import org.example.model.FlightSegment;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GroundTimeExceedsTwoHoursFilterTest {

    @Test
    public void testFilter_NoSegmentsExceedingTwoHoursGroundTime() {
        // Arrange
        GroundTimeExceedsTwoHoursFilter filter = new GroundTimeExceedsTwoHoursFilter();
        LocalDateTime departure1 = LocalDateTime.now();
        LocalDateTime arrival1 = departure1.plusHours(1);
        LocalDateTime departure2 = arrival1.plusMinutes(30);
        LocalDateTime arrival2 = departure2.plusHours(1);
        Flight validFlight = new Flight(Arrays.asList(
                new FlightSegment(departure1, arrival1),
                new FlightSegment(departure2, arrival2)
        ));

        // Act
        List<Flight> result = filter.filter(Arrays.asList(validFlight));

        // Assert
        assertEquals(1, result.size());
        assertEquals(validFlight, result.get(0));
    }

    @Test
    public void testFilter_SegmentsExceedingTwoHoursGroundTime() {
        // Arrange
        GroundTimeExceedsTwoHoursFilter filter = new GroundTimeExceedsTwoHoursFilter();
        LocalDateTime departure1 = LocalDateTime.now();
        LocalDateTime arrival1 = departure1.plusHours(1);
        LocalDateTime departure2 = arrival1.plusHours(2).plusMinutes(1); // Добавим 1 минуту, чтобы превысить 2 часа
        LocalDateTime arrival2 = departure2.plusHours(1);
        Flight invalidFlight = new Flight(Arrays.asList(
                new FlightSegment(departure1, arrival1),
                new FlightSegment(departure2, arrival2)
        ));

        // Act
        List<Flight> result = filter.filter(Arrays.asList(invalidFlight));

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    public void testCalculateGroundTime() {
        // Arrange
        GroundTimeExceedsTwoHoursFilter filter = new GroundTimeExceedsTwoHoursFilter();
        LocalDateTime departure1 = LocalDateTime.now();
        LocalDateTime arrival1 = departure1.plusHours(1);
        LocalDateTime departure2 = arrival1.plusMinutes(30);
        LocalDateTime arrival2 = departure2.plusHours(1);
        Flight flight = new Flight(Arrays.asList(
                new FlightSegment(departure1, arrival1),
                new FlightSegment(departure2, arrival2)
        ));

        // Act
        long groundTime = filter.calculateGroundTime(flight);

        // Assert
        assertEquals(30, groundTime); // 30 minutes
    }
}
