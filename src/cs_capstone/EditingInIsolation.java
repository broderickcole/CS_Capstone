
package cs_capstone;

/**
 *
 * @author colebroderick
 */
public class EditingInIsolation extends FlightData {
    //Test 
    
    
    // everything is working in order
    
    private int nubTest;

    public EditingInIsolation(int nubTest, String flightId, String departureTime, String arrivalTime, String assignedAircraftId, double passengerCount, double totalSeats) {
        super(flightId, departureTime, arrivalTime, assignedAircraftId, passengerCount, totalSeats);
        this.nubTest = nubTest;
    }

    public int getNubTest() {
        return nubTest;
    }

    public void setNubTest(int nubTest) {
        this.nubTest = nubTest;
    }


    
}
