package cs_capstone;

import java.util.ArrayList;

/**
 *
 * @author colebroderick
 */
public class FlightData {

    // The varibles that hold the flight data attriubites 
    private String flightId;
    private String departureTime;
    private String arrivalTime;
    private String assignedAircraftId;
    private double passengerCount;
    private double totalSeats;
    private double loadF;

    //Contructor to initialize my newly created objects
    public FlightData(String flightId, String departureTime,
            String arrivalTime, String assignedAircraftId,
            double passengerCount, double totalSeats) {
        this.flightId = flightId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.assignedAircraftId = assignedAircraftId;
        this.passengerCount = passengerCount;
        this.totalSeats = totalSeats;
    }

    // Class that prints the flight data in a readable format
    public static void printFlights(FlightData[] flights) {

        for (FlightData flight : flights) {
            System.out.printf("The information for %s is as follows: %n", flight.getFlightId());
            System.out.println("Flight ID: " + flight.getFlightId());
            System.out.println("Departure Time: " + flight.getDepartureTime());
            System.out.println("Arrival Time: " + flight.getArrivalTime());
            System.out.println("Assigned Aircraft ID: " + flight.getAssignedAircraftId());
            System.out.println("Passenger count: " + flight.getPassengerCount());
            System.out.printf("Total Seats on %s is: %.0f %n", flight.flightId, flight.getTotalSeats());
            System.out.printf("The load factor of %s is: %.5f%% %n %n", flight.getFlightId(), flight.getLoadFactor());

        }

    }

    //Sorting method
    public static void sortByLoadFactor(FlightData[] flights) {
        for (int i = 0; i < flights.length - 1; i++) {
            for (int j = i; j < flights.length; j++) {
                if (flights[j].getLoadFactor() > flights[i].getLoadFactor()) {
                    FlightData temp = flights[i];
                    flights[i] = flights[j];
                    flights[j] = temp;
                }
            }
        }

    }

    public static String printNoDuplicates(FlightData[] flights) {
        ArrayList<String> seenIDs = new ArrayList<>();
        for (FlightData flight : flights) {
            if (!seenIDs.contains(flight.getFlightId())) {
                System.out.printf("The information for %s is as follows: %n", flight.getFlightId());
                System.out.println("Flight ID: " + flight.getFlightId());
                System.out.println("Departure Time: " + flight.getDepartureTime());
                System.out.println("Arrival Time: " + flight.getArrivalTime());
                System.out.println("Assigned Aircraft: " + flight.getAssignedAircraftId());
                System.out.println("Passenger count: " + flight.getPassengerCount());
                System.out.printf("Total Seats on %s is: %.0f %n", flight.flightId, flight.getTotalSeats());
                System.out.printf("The load factor of %s is: %.5f%% %n %n", flight.getFlightId(), flight.getLoadFactor());
                seenIDs.add(flight.getFlightId());
            }
        }
        return null;

    }

    //Method that groups flights by their aircraft ID
    public static void groupByAircraftID(FlightData[] flights) {
        int n = flights.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (flights[j].getAssignedAircraftId().compareTo(flights[j + 1].getAssignedAircraftId()) > 0) {
                    FlightData temp = flights[j];
                    flights[j] = flights[j + 1];
                    flights[j + 1] = temp;
                }
            }
        }
    }

    // Method that gets the load factor by doing basic arithmetic calculations
    public double getLoadFactor() {
        double loadF = (passengerCount * 100) / totalSeats;
        return loadF;

    }

    //Getters and setters 
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAssignedAircraftId() {
        return assignedAircraftId;
    }

    public void setAssignedAircraftId(String assignedAircraftId) {
        this.assignedAircraftId = assignedAircraftId;
    }

    public double getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(double passengerCount) {
        this.passengerCount = passengerCount;
    }

    public double getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(double totalSeats) {
        this.totalSeats = totalSeats;
    }

    public double getLoadF() {
        return loadF;
    }

    public void setLoadF(double loadF) {
        this.loadF = loadF;
    }
}
