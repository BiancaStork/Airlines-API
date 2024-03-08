package codoacodo.flights.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import codoacodo.flights.model.Flight;
import codoacodo.flights.repository.FlightRepository;

import java.util.List;

@Service
public class FlightService {

  @Autowired
  FlightRepository flightRepository;

  public List<Flight> allFlights(){
    return flightRepository.findAll() ;
  }
    


}
