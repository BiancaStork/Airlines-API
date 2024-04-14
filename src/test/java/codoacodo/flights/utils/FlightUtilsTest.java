package codoacodo.flights.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import codoacodo.flights.model.Flight;

public class FlightUtilsTest {
    @Autowired
    FlightUtils flightUtils;


    @Test
    void testDetectedOffers() {
        List<Flight> flightList = new ArrayList<>();
        Flight flight1 = new Flight(1L, "EZE", "COR", "20:00", "23:00", 26500.00, "diaria");
        Flight flight2 = new Flight(2L, "AEP", "MZA", "08:00", "12:00", 48600.00, "MENSUAL");
        Flight flight3 = new Flight(3L, "COR", "MZA", "18:00", "20:00", 58200.00, "MENSUAL");
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);

    }
}
