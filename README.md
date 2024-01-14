Flight Filtering Module
This project implements a flight filtering module for processing and filtering flight itineraries based on various rules. The goal is to create a flexible module capable of handling dynamic rule sets for filtering large sets of flights. The code is organized within the com.gridnine.testing package.

Project Structure
The project includes the following classes and interfaces:

Flight - Represents a flight itinerary consisting of multiple segments.
Segment - Represents an atomic transport unit with departure and arrival date/time.
FlightBuilder - A factory class to create sample flight instances for testing.
FlightFilter - Interface for filtering flights based on specific rules.
FlightFilterImpl - Implementation of the FlightFilter interface with methods to apply filtering rules.
Main - The main class with a main method to demonstrate the application by processing a test set of flights.
Usage
To use the flight filtering module, follow these steps:

Clone the repository.
Open the project in your preferred Java development environment.
Run the Main class.
The Main class demonstrates the functionality by applying different filtering rules to a set of test flights obtained from FlightBuilder.createFlights().

Filtering Rules
Flights with Departure Before Current Time:

Filter out flights with a departure date/time earlier than the current moment.
Segments with Arrival Before Departure:

Exclude segments where the arrival date/time is earlier than the departure date/time.
Flights with Total Ground Time Exceeding Two Hours:

Remove flights where the total time spent on the ground (interval between the arrival of one segment and the departure of the next) exceeds two hours.
Running the Application
The Main class contains a main method, which initializes the flight filtering module, applies each filtering rule, and prints the results to the console.

Testing
The project includes JUnit tests to validate the functionality of the FlightFilter implementation. Tests cover various scenarios for each filtering rule.

To run the tests, use your IDE's testing capabilities or run the following command in the project directory:

bash
Copy code
./gradlew test
Note
This project is console-based, and no user interface is provided. All results are printed to the console.

Feel free to explore, modify, and extend the code as needed for your specific requirements. If you encounter any issues or have suggestions for improvement, please create an issue on the GitHub repository.

Thank you for using the Flight Filtering Module!
