

package cs_capstone;

/**
 *
 * @author colebroderick
 */
public class FlightData {

    public String flightId;
    public String departureTime;
    public String arrivalTime;
    public String assignedAircraftId;
    public double passengerCount;
    public double totalSeats;
    public double loadF;

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
    
        public static void sortByLoadFactor(FlightData[] flights) {
        for (int i = 0; i < flights.length - 1; i++) {
            // ** We do not decrease the code below becuase you dont want it to compare the same number. 
            //         and needs to be compared to the next number
            for (int j = i; j < flights.length; j++) {
                // ** Below we are comparing the load factors
                if (flights[j].getLoadFactor() > flights[i].getLoadFactor()) {
                    // ** Below is the swap if [j] is larger than [i] 
                    //     we have to create a temporary varible for [i] so we dont overwrite it and loose it 
                    FlightData temp = flights[i];
                    flights[i] = flights[j];
                    // then we store the temp [i] in [j]'s place, which is the swap
                    flights[j] = temp;
                }
            }
        }

    }

    public double getLoadFactor() {
        double loadF = (passengerCount * 100) / totalSeats;
        return loadF;

    }

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