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
        /*For loop that runs through the array that was created in the CS_Capstone main class
        so that it can print the elements of each object in a readable format
         */
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

    /*
          Method that was created to sort the flights by their load factor
          
     */
    public static void sortByLoadFactor(FlightData[] flights) {
        for (int i = 0; i < flights.length - 1; i++) {
            // ** We do not decrease the code below becuase we dont want it to compare the same number. 
            //         and needs to be compared to the next number
            for (int j = i; j < flights.length; j++) {
                //  Below we are comparing the load factors
                if (flights[j].getLoadFactor() > flights[i].getLoadFactor()) {
                    //  Below is the swap; if [j] is larger than [i] 
                    //     we have to create a temporary varible for [i] so we dont overwrite it and loose it 
                    FlightData temp = flights[i];
                    flights[i] = flights[j];
                    // then we store the temp [i] in [j]'s place, which is the swap
                    flights[j] = temp;
                    //the loops goes until flights[j] LoadFactor is greater than > flights[i] LoadFactor is false
                }
            }
        }

    }
    
    
        public static String printNoDuplicates(FlightData[] flights) {
        // Below is the ArrayList that uses the java.utility class I imported. 
        ArrayList<String> seenIDs = new ArrayList<>();
        // ** Creating a flight varible in the flights string we created in the main method.
        //         so we can loop through all the flights
        for (FlightData flight : flights) {
            // The "!" means does not. If we do not have the "!" it means If seenIDs DOES contain the Flight ID
            //      then to print it out. We only want Flights to be printed that are not dups 
            //      and then have them added to our array list
            if (!seenIDs.contains(flight.getFlightId())) {
                System.out.printf("The information for %s is as follows: %n", flight.getFlightId());
                System.out.println("Flight ID: " + flight.getFlightId());
                System.out.println("Departure Time: " + flight.getDepartureTime());
                System.out.println("Arrival Time: " + flight.getArrivalTime());
                System.out.println("Assigned Aircraft: " + flight.getAssignedAircraftId());
                System.out.println("Passenger count: " + flight.getPassengerCount());
                System.out.printf("Total Seats on %s is: %.0f %n", flight.flightId, flight.getTotalSeats());
                System.out.printf("The load factor of %s is: %.5f%% %n %n", flight.getFlightId(), flight.getLoadFactor());

                // ** Add this flight id to seenIDs, so we never print another flight with this same ID again.
                // ** Any flights whose IDs are in this list will not get printed out anymore.
                seenIDs.add(flight.getFlightId());
            }
        }
        // *** The for loop needs a return statment but since we are not returning anything, we can return NULL
        return null;

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
