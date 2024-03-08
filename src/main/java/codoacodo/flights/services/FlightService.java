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
// trae el vuelo que coincide con el id
  public Flight flightById(Long id){
    //mejorar buscando la manera de enviar al usuario un mensaje de error en lugar de null
    return flightRepository.findById(id).orElse(null);
    
    
  }
//crea un nuevo vuelo en la BD
  public void newFlight(Flight flight){
    flightRepository.save(flight);
  }
//actualiza un vuelo existente en la BD
  public Flight updateFlight(){
    return null;
  }
//borra un vuelo de la base de datos
  public static Flight deleteFlight(){
    return null;
  }

  
    


}
