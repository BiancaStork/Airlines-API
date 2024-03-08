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
//Trae todos los vuelos
  public List<Flight> allFlights(){
    return flightRepository.findAll() ;
  }

//Trae el vuelo que coincide con el id
  public Flight flightById(Long id){
    //mejorar buscando la manera de enviar al usuario un mensaje de error en lugar de null
    return flightRepository.findById(id).orElse(null);    
  }

//Crea un nuevo vuelo en la BD
  public void newFlight(Flight flight){
    flightRepository.save(flight);
  }

//Actualiza un vuelo existente en la BD
  public Flight updateFlight(Flight flight){
    //guardo los cambios
    flightRepository.save(flight);
    return flightRepository.findById(flight.getId()).orElse(null);
  }

//Elimina un vuelo de la base de datos
  public void deleteFlight(Long id){
    flightRepository.deleteById(id);
  }

}
