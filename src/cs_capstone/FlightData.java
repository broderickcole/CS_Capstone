package cs_capstone;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;
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
            System.out.println("Passenger count: " + (int) flight.getPassengerCount());
            System.out.printf("Total Seats on %s is: %d %n", flight.flightId, (int) flight.getTotalSeats());
            System.out.printf("The load factor of %s is: %.5f%% %n %n", flight.getFlightId(), flight.getLoadFactor());

        }

    }
    
     public static void storingDataInMD(FlightData[] flights) {

        MongoClient mongo = new MongoClient("3.141.244.5", 27017);

        MongoCredential credential;
        credential = MongoCredential.createCredential("ColeB", "flights",
                "password".toCharArray());
        System.out.println("Connected to the database successfully");

        // Accessing the database 
        MongoDatabase database = mongo.getDatabase("flights");
        System.out.println("Database Name: " + database.getName());
        System.out.println("Credentials :" + credential);

        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection("FlightData");
        System.out.println("Collection sampleCollection selected successfully");
        

        for (FlightData flight : flights) {
            Document FlightData = new Document();
            //Inserting data into the collection
            FlightData.append("flight ID", flight.getFlightId());
            FlightData.append("Departure time", flight.departureTime);
            FlightData.append("Arrival Time", flight.getArrivalTime());
            FlightData.append("Assgined aircraft ID:", flight.getAssignedAircraftId());
            FlightData.append("Passenger Count", (int)flight.getPassengerCount());
            FlightData.append("Total Seats", (int)flight.getTotalSeats());
            FlightData.append("The Load Factor is", flight.getLoadFactor());
            System.out.println("Document inserted successfully");
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

    public static void printNoDuplicates(FlightData[] flights) {
        ArrayList<String> seenIDs = new ArrayList<>();
        for (FlightData flight : flights) {
            for (int i = 0; i > flights.length -1; i--) {
                if (!seenIDs.contains(flight.getFlightId())) {
                    System.out.printf("The information for %s is as follows: %n", flight.getFlightId());
                    System.out.println("Flight ID: " + flight.getFlightId());
                    System.out.println("Departure Time: " + flight.getDepartureTime());
                    System.out.println("Arrival Time: " + flight.getArrivalTime());
                    System.out.println("Assigned Aircraft: " + flight.getAssignedAircraftId());
                    System.out.printf("Passenger count: %d", (int) flight.getPassengerCount());
                    System.out.printf("Total Seats on %s is: %d %n", flight.flightId, (int) flight.getTotalSeats());
                    System.out.printf("The load factor of %s is: %.5f%% %n %n", flight.getFlightId(), flight.getLoadFactor());
                    seenIDs.add(flight.getFlightId());
                }
            }
        }

    }

    //Method that groups flights by their aircraft ID
    public static void groupByAircraftID(FlightData[] flights) {
        FlightData temp;
      
        for (int i = flights.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i ; j++) {
                if (flights[j].getAssignedAircraftId().compareTo(flights[j + 1].getAssignedAircraftId()) > 0) {
                    temp = flights[j];
                    flights[j] = flights[j + 1];
                    flights[j + 1] = temp;
                }
            }
        }
    }
    
    // Method that gets the load factor by doing basic arithmetic calculations
    public double getLoadFactor() {
        double loadFactor = (passengerCount * 100) / totalSeats;
        return loadFactor;

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
