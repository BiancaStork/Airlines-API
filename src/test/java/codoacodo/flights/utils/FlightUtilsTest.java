package codoacodo.flights.utils;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import codoacodo.flights.models.Flight;
import codoacodo.flights.models.FlightDto;

@SpringBootTest

class FlightUtilsTest {
   
  
      
        @Autowired        
        FlightUtils flightUtils;
        
        @BeforeEach
        void setup(){
           //List<Flight> flightList;
           //List<FlightDto> flightDtoList;
           
        }

        @Test
        void flightMapperList() {
            double dolarPrice= 1015;            
            List<Flight> flightList = new ArrayList<>();
            List<FlightDto> flightDtoList = new ArrayList<>();
            Flight flight = new Flight();           
            flight.setId(1L);
            flight.setOrigin("IGR");
            flight.setDestiny("EZE");
            flight.setDepartureDateTime("21:00");
            flight.setArrivalDateTime("23:00");
            flight.setPrice(200);
            flight.setFrecuency("SEMANAL");

            flightList.add(flight);

            //llamo a la funcionalidad
            flightDtoList = flightUtils.flightMapperList(flightList, dolarPrice);

            //verificar la salida/comportamiento

            FlightDto flightDto = flightDtoList.get(0);
            assertEquals(1, flightDto.getId());


            
            
        }

    
}
