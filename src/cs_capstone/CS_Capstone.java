package cs_capstone;

/**
 *
 * @author colebroderick
 */
public class CS_Capstone {

    //Testing to make sure my repo is set up correctly. 
    public static void main(String[] args) {
        FlightData flight1 = new FlightData("flight_1", "10:00:00", "12:00:00", "aircraft_1", 100, 143);
        FlightData flight2 = new FlightData("flight_2", "07:00:00", "13:00:00", "aircraft_2", 121, 143);
        FlightData flight3 = new FlightData("flight_3", "16:00:00", "19:00:00", "aircraft_1", 166, 175);
        FlightData flight4 = new FlightData("flight_1", "13:00:00", "17:00:00", "aircraft_4", 147, 175);

        FlightData[] flights = {flight1, flight2, flight3, flight4};

        System.out.println(
                "~~ BEFORE SORT ~~ \n");
        FlightData.printFlights(flights);



        System.out.println("\n \n ------------------------ \n \n");

        System.out.println("~~ AFTER SORT ~~ \n");
        FlightData.sortByLoadFactor(flights);
        FlightData.printFlights(flights);
    }

}
