package com.keyin.http.cli;

import java.util.List;

import com.keyin.domain.Aircraft;
import com.keyin.domain.Airport;
import com.keyin.domain.Cities;
import com.keyin.domain.Passenger;
import com.keyin.http.client.RESTClient;

public class HTTPRestCLIApplication {
    private RESTClient restClient;

    public String generateAirportReport() {
        List<Airport> airports = getRestClient().getAllAirports();

        StringBuffer report = new StringBuffer();

        for (Airport airport : airports) {
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getCode());

            if (airports.indexOf(airport) != (airports.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public String generateAircraftReport() {
        List<Aircraft> aircrafts = getRestClient().getAllAircraft();

        StringBuffer report = new StringBuffer();

        for (Aircraft aircraft : aircrafts) {
            report.append(aircraft.getType());
            report.append(" - ");
            report.append(aircraft.getAirlineName());
            report.append(" - ");
            report.append(aircraft.getNumberOfPassengers());

            if (aircrafts.indexOf(aircraft) != (aircrafts.size() - 1)) {
                report.append(",");
            }
    }

        System.out.println(report.toString());

        return report.toString();
    }

    public String generatePassengerReport() {
        List<Passenger> passengers = getRestClient().getAllPassengers();

        StringBuffer report = new StringBuffer();

        for (Passenger passenger : passengers) {
            report.append(passenger.getFirstName());
            report.append(" - ");
            report.append(passenger.getLastName());
            report.append(" - ");
            report.append(passenger.getPhoneNumber());

            if (passengers.indexOf(passenger) != (passengers.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public String generateCitiesReport() {
        List<Cities> cities = getRestClient().getAllCities();

        StringBuffer report = new StringBuffer();

        for (Cities city : cities) {
            report.append(city.getName());
            report.append(" - ");
            report.append(city.getState());
            report.append(" - ");
            report.append(city.getPopulation());

            if (cities.indexOf(city) != (cities.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    private void listGreetings() {
        System.out.println(getRestClient().getResponseFromHTTPRequest());
    }

    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }

        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        HTTPRestCLIApplication cliApp = new HTTPRestCLIApplication();

        String serverURL = "http://localhost:8080/api/aircrafts";

        if (serverURL != null && !serverURL.isEmpty()) {

            RESTClient restClient = new RESTClient();
            restClient.setServerURL(serverURL);

            cliApp.setRestClient(restClient);

            if (serverURL.contains("greeting")) {
                cliApp.listGreetings();
            } else {
                // Comment out the reports you don't need!

                // cliApp.generateAirportReport();
                cliApp.generateAircraftReport();
            //     cliApp.generatePassengerReport();
            //     cliApp.generateCitiesReport();
            }
        }

    }
}
