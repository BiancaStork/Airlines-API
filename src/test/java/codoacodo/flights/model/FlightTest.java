package codoacodo.flights.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class FlightTest {
    private static Flight flight;

    @Test
    public void setAndGetOriginTest(){
        String testedOrigin= "AEP";
        flight.setOrigin(testedOrigin);
        System.out.println("Se le asigna el Origen: "+ testedOrigin);
        Assertions.assertEquals(flight.getOrigin(), testedOrigin);
    }

    @Test
    public void setAndGetDestinyTest(){
        String testedDestiny="COR";
        flight.setDestiny(testedDestiny);
        System.out.println("Se le asigna el Destino: "+ testedDestiny);
        Assertions.assertEquals(flight.getDestiny(), testedDestiny);
    }

    @BeforeAll
    public static void setUp(){
        System.out.println("Se esta creando el Vuelo!");
        flight = new Flight();

    } 
}
