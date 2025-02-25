package com.keyin;

import com.keyin.domain.Airport;
import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;
import com.keyin.domain.Aircraft;
import com.keyin.domain.Cities;
import com.keyin.domain.Passenger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HTTPRestCLIApplicationTest {
    @Mock
    private RESTClient mockRESTClient;

    @Test
    public void testGenerateAirportReport() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        Airport stJohnsAirport = new Airport();
        stJohnsAirport.setCode("YYT");
        stJohnsAirport.setName("St. John's Airport");
        stJohnsAirport.setId(1);

        List<Airport> airportList = new ArrayList<Airport>();
        airportList.add(stJohnsAirport);

        Mockito.when(mockRESTClient.getAllAirports()).thenReturn(airportList);

        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAirportReport().contains("YYT"));
    }

    @Test
    public void testGenerateAircraftReport() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        Aircraft spiritAircraft = new Aircraft();
        spiritAircraft.setType = "A319";
        spiritAircraft.setAirlineName = "Spirit";
        spiritAircraft.numberOfPassengers = 25;

        List<Aircraft> aircraftList = new ArrayList<Aircraft>();
        aircraftList.add(spiritAircraft);

        Mockito.when(mockRESTClient.getAllAircraft()).thenReturn(aircraftList);

        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAircraftReport().contains("A319"));
    }

    @Test
    public void testGeneratePassengerReport() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        Passenger passenger = new Passenger();
        passenger.setFirstName = "John";
        passenger.setLastName = "Doe";
        passenger.setPhoneNumber = "123-456-7890";

        List<Passenger> passengerList = new ArrayList<Passenger>();
        passengerList.add(passenger);

        Mockito.when(mockRESTClient.getAllPassengers()).thenReturn(passengerList);

        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generatePassengerReport().contains("John"));
    }

    @Test
    public void testGenerateCitiesReport() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        Cities cities = new Cities();
        cities.setCityName = "St. John's";
        cities.setStateName = "Newfoundland and Labrador";
        cities.setPopulation = 100000;

        List<Cities> citiesList = new ArrayList<Cities>();
        citiesList.add(cities);

        Mockito.when(mockRESTClient.getAllCities()).thenReturn(citiesList);

        httpRestCLIApplicationUnderTest.setRestClient(mockRESTClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateCitiesReport().contains("St. John's"));
    }


    public void testGenerateAirportReportWithError() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        RESTClient restClient = new RESTClient();
        restClient.setServerURL("http://localhost:8080/airports");

        httpRestCLIApplicationUnderTest.setRestClient(restClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAirportReport().contains("YYT"));
    }

    public void testGenerateAircraftReportWithError() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        RESTClient restClient = new RESTClient();
        restClient.setServerURL("http://localhost:8080/aircraft");

        httpRestCLIApplicationUnderTest.setRestClient(restClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAircraftReport().contains("A319"));
    }

    public void testGeneratePassengerReportWithError() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        RESTClient restClient = new RESTClient();
        restClient.setServerURL("http://localhost:8080/passengers");

        httpRestCLIApplicationUnderTest.setRestClient(restClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generatePassengerReport().contains("John"));
    }

    public void testGenerateCitiesReportWithError() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();

        RESTClient restClient = new RESTClient();
        restClient.setServerURL("http://localhost:8080/cities");

        httpRestCLIApplicationUnderTest.setRestClient(restClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateCitiesReport().contains("St. John's"));
    }
}
