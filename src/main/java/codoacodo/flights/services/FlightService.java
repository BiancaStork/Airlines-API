package codoacodo.flights.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codoacodo.flights.model.Flight;
import codoacodo.flights.repository.FlightRepository;
import codoacodo.flights.utils.FlightUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

  @Autowired /*esta anotacion, me permite llamar a los metodos del repositorio --- "inyectar" */
  FlightRepository flightRepository;

  @Autowired
  FlightUtils flightUtils;
  


//Trae todos los vuelos
  public List<Flight> allFlights(){
    return flightRepository.findAll() ;
  }

//Trae el vuelo que coincide con el id
  public Flight flightById(Long id){
    //mejorar buscando la manera de enviar al usuario un mensaje de error en lugar de null
    return flightRepository.findById(id).orElse(null);    
  }

  

public List<Flight> getOffers(Integer offerPrice) {
    List<Flight> flights = flightRepository.findAll();
    return flightUtils.detectedOffers(flights, offerPrice);
    
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
