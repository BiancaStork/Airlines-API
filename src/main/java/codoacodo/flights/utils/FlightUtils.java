package codoacodo.flights.utils;

import org.springframework.stereotype.Component;

import codoacodo.flights.models.Flight;
import codoacodo.flights.models.FlightDto;
//import codoacodo.flights.models.Dolar;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component /*con esta anotacion le dijo que se trata de un componente */

public class FlightUtils {
    
    public List<Flight> detectedOffers(List<Flight> flightList, double offerPrice){
        List<Flight> offers = new ArrayList<>();
       offers= flightList.stream()
            .filter(f -> f.getPrice() <= offerPrice)  // aplicamos el filtro para mantener solo los vuelos cuyo precio es menor o igual
            //recopilamos los resultados en una nueva lista con
            .collect(Collectors.toList());
       return offers;
    }

    public FlightDto flightMapper(Flight f, double price){
       return new FlightDto(f.getId(), f.getOrigin(), f.getDestiny(), f.getDepartureDateTime(), f.getArrivalDateTime(), f.getPrice() * price, f.getFrecuency(), f.getCompany());
    }

    public List<FlightDto> flightMapperList (List<Flight> flights, double price){
       List<FlightDto> flightDtoList = new ArrayList<>();
       for (Flight f : flights){
          flightDtoList.add(new FlightDto(f.getId(), f.getOrigin(), f.getDestiny(), f.getDepartureDateTime(), f.getArrivalDateTime(), f.getPrice() * price, f.getFrecuency(), f.getCompany()));
       };

       return flightDtoList;

    }
}
