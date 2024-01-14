# Flight Filtering Module

This project implements a flight filtering module for processing and filtering flight itineraries based on various rules. The goal is to create a flexible module capable of handling dynamic rule sets for filtering large sets of flights. The code is organized within the `com.gridnine.testing` package.

## Project Structure

The project includes the following classes and interfaces:

1. **Flight** - Represents a flight itinerary consisting of multiple segments.
2. **Segment** - Represents an atomic transport unit with departure and arrival date/time.
3. **FlightBuilder** - A factory class to create sample flight instances for testing.
4. **FlightFilter** - Interface for filtering flights based on specific rules.
5. **FlightFilterImpl** - Implementation of the `FlightFilter` interface with methods to apply filtering rules.
6. **Main** - The main class with a `main` method to demonstrate the application by processing a test set of flights.

## Usage

To use the flight filtering module, follow these steps:

1. Clone the repository.
2. Open the project in your preferred Java development environment.
3. Run the `Main` class.

The `Main` class demonstrates the functionality by applying different filtering rules to a set of test flights obtained from `FlightBuilder.createFlights()`.

## Filtering Rules

1. **Flights with Departure Before Current Time:**
   - Filter out flights with a departure date/time earlier than the current moment.

2. **Segments with Arrival Before Departure:**
   - Exclude segments where the arrival date/time is earlier than the departure date/time.

3. **Flights with Total Ground Time Exceeding Two Hours:**
   - Remove flights where the total time spent on the ground (interval between the arrival of one segment and the departure of the next) exceeds two hours.

## Running the Application

The `Main` class contains a `main` method, which initializes the flight filtering module, applies each filtering rule, and prints the results to the console.

## Testing

The project includes JUnit tests to validate the functionality of the `FlightFilter` implementation. Tests cover various scenarios for each filtering rule.

To run the tests, use your IDE's testing capabilities or run the following command in the project directory:

```bash
./gradlew test
