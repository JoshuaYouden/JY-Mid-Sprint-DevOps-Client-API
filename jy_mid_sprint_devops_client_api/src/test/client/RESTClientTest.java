package com.keyin.client;

import com.keyin.domain.Airport;
import com.keyin.domain.Aircraft;
import com.keyin.domain.Cities;
import com.keyin.domain.Passenger;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RESTClientTest {
    @Test
    public void testBuildAirportListFromResponse() throws Exception {
        String jsonResponse = "[\n{\n\"id\": 1,\n\"name\": \"St. John's\",\n\"code\": \"YYT\"\n},\n" +
                "{\n\"id\": 2,\n\"name\": \"Deer Lake\",\n\"code\": \"YDF\"\n}\n]";

        RESTClient restClientUnderTest = new RESTClient();

        List<Airport> airportList = restClientUnderTest.buildAirportListFromResponse(jsonResponse);

        Assertions.assertTrue(airportList.contains(new Airport("YYT")));

        Assertions.assertTrue(airportList.contains(new Airport("YDF")));
    }

    @Test
    public void testBuildPassengerListFromResponse() throws Exception {
        String jsonResponse = "[\n{\n\"id\": 1,\n\"firstName\": \"John\",\n\"lastName\": \"Doe\",\n\"phoneNumber\": \"123-456-7890\"\n},\n" +
                "{\n\"id\": 2,\n\"firstName\": \"Jane\",\n\"lastName\": \"Doe\",\n\"phoneNumber\": \"987-654-3210\"\n}\n]";

        RESTClient restClientUnderTest = new RESTClient();

        List<Passenger> passengerList = restClientUnderTest.buildPassengerListFromResponse(jsonResponse);

        Assertions.assertTrue(passengerList.contains(new Passenger("John")));

        Assertions.assertTrue(passengerList.contains(new Passenger("Jane")));
    }

    @Test
    public void testBuildAircraftListFromResponse() throws Exception {
        String jsonResponse = "[\n{\n\"id\": 1,\n\"type\": \"A319\",\n\"airlineName\": \"Spirit\",\n\"numberOfPassengers\": 200\n},\n" +
                "{\n\"id\": 2,\n\"type\": \"A320\",\n\"airlineName\": \"JetBlue\",\n\"numberOfPassengers\": 300\n}\n]";

        RESTClient restClientUnderTest = new RESTClient();

        List<Aircraft> aircraftList = restClientUnderTest.buildAircraftListFromResponse(jsonResponse);

        Assertions.assertTrue(aircraftList.contains(new Aircraft("A319")));

        Assertions.assertTrue(aircraftList.contains(new Aircraft("A320")));
    }

    @Test
    public void testBuildCitiesListFromResponse() throws Exception {
        String jsonResponse = "[\n{\n\"id\": 1,\n\"name\": \"St. John's\",\n\"state\": \"Newfoundland and Labrador\",\n\"population\": 100000\n},\n" +
                "{\n\"id\": 2,\n\"name\": \"Toronto\",\n\"state\": \"Ontario\",\n\"population\": 200000\n}\n]";

        RESTClient restClientUnderTest = new RESTClient();

        List<Cities> citiesList = restClientUnderTest.buildCitiesListFromResponse(jsonResponse);

        Assertions.assertTrue(citiesList.contains(new Cities("St. John's")));

        Assertions.assertTrue(citiesList.contains(new Cities("Toronto")));
    }
}
