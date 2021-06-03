package cs_capstone;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import java.util.Iterator;
import org.bson.Document;

/**
 *
 * @author colebroderick
 */
public class CS_Capstone {

    //Creating new objects in my flight data classes that can later be called on 
    public static void main(String[] args) {

        // Creating a Mongo client 
        MongoClient mongo = new MongoClient("127.0.0.1", 27017);

        MongoCredential credential;
        credential = MongoCredential.createCredential("ColeB", "flights",
                "password".toCharArray());
        System.out.println("Connected to the database successfully");
        
        
        // Accessing the database 
        MongoDatabase database = mongo.getDatabase("flights");
        System.out.println("Database Name: " + database.getName());
        System.out.println("Credentials ::" + credential);

        MongoCollection<Document> collection = database.getCollection("myCollection");


        /*
        //Retrieving the documents
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        
        while (it.hasNext()) {
            System.out.println(it.next());
        }
         */
//        FlightData flight1 = new FlightData("flight_1", "10:00:00", "12:00:00", "aircraft_1", 100, 143);
//        FlightData flight2 = new FlightData("flight_2", "07:00:00", "13:00:00", "aircraft_2", 121, 143);
//        FlightData flight3 = new FlightData("flight_3", "16:show 00:00", "19:00:00", "aircraft_1", 166, 175);
//        FlightData flight4 = new FlightData("flight_1", "13:00:00", "17:00:00", "aircraft_4", 147, 175);
//
//        // Creating an array of the objects
//        FlightData[] flights = {flight1, flight2, flight3, flight4};
//
//        // Pringting the flights out in the order they were put in
//        System.out.println("~~ BEFORE SORT ~~ \n");
//        FlightData.printFlights(flights);
//
//        System.out.println("\n \n ------------------------ \n \n");
//
//        /**
//         * After using the method that gets the loadfactor for each flight, the
//         * sorting method that is also in the FlightData class reorganized the
//         * flights and then prints the flights
//         */
//        System.out.println("~~ AFTER SORT ~~ \n");
//        FlightData.sortByLoadFactor(flights);
//        FlightData.printFlights(flights);
//
//        System.out.println("\n \n ------------------------ \n \n");
//
//        System.out.println("~~ DO NOT PRINT DUPLICATE FLIGHTS ~~ \n");
//        FlightData.printNoDuplicates(flights);
//        FlightData.printFlights(flights);
    }

}
