/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_capstone;

/**
 *
 * @author colebroderick
 */
public class CS_Capstone {
    
    public static void main(String[] args) {
        
        //Just making sure git is correct 
        FlightData flight1 = new FlightData("flight_1", "10:00:00", "12:00:00", "aircraft_1", 100, 143);
        FlightData flight2 = new FlightData("flight_2", "07:00:00", "13:00:00", "aircraft_2", 121, 143);
        FlightData flight3 = new FlightData("flight_3", "16:00:00", "19:00:00", "aircraft_1", 166, 175);
        FlightData flight4 = new FlightData("flight_1", "13:00:00", "17:00:00", "aircraft_4", 147, 175);

        FlightData[] flights = {flight1, flight2, flight3, flight4};

        System.out.println(
                "~~ BEFORE SORT ~~ \n");
        FlightData.printFlights(flights);
        
        System.out.println("Hello");
        
    }
    
}
