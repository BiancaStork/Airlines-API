package codoacodo.flights.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codoacodo.flights.models.Company;
import codoacodo.flights.models.Flight;
import codoacodo.flights.models.FlightDto;
import codoacodo.flights.configuration.FlightConfiguration;
import codoacodo.flights.exceptions.ResourceNotFoundException;
import codoacodo.flights.repository.CompanyRepository;
import codoacodo.flights.repository.FlightRepository;
import codoacodo.flights.utils.FlightUtils;

import java.util.List;



@Service
public class FlightService {

  @Autowired /*esta anotacion, me permite llamar a los metodos del repositorio --- "inyectar" */
  FlightRepository flightRepository;

  @Autowired
  FlightUtils flightUtils;
  
  @Autowired
  FlightConfiguration flightConfiguration;

  @Autowired
  CompanyRepository companyRepository;
  


//Trae todos los vuelos desde el DTO
  public List<FlightDto> allFlights(){   
    List<Flight> flights = flightRepository.findAll();
    double dolarPrice = getDolar();
    return flightUtils.flightMapperList(flights, dolarPrice);    
  }

  
//Trae el vuelo que coincide con el id
  public Flight flightById(Long id) throws ResourceNotFoundException{
   
    return flightRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Flight not found", "Flight", "id", id));    
  }

  

public List<Flight> getOffers(Integer offerPrice) {
    List<Flight> flights = flightRepository.findAll();
    return flightUtils.detectedOffers(flights, offerPrice);
    
}

//Crea un nuevo vuelo en la BD
  public void newFlight(Flight flight, Long companyId) throws ResourceNotFoundException{
    //Company company = companyRepository.findById(companyId).orElse(null);
    Company company = companyRepository.findById(companyId).orElseThrow(()-> new ResourceNotFoundException("Company not found", "Company", "id", companyId));
   
    flight.setCompany(company);
    flightRepository.save(flight);
  }

//Actualiza un vuelo existente en la BD
  public Flight updateFlight(Flight flight) throws ResourceNotFoundException{
    //guardo los cambios
    flightRepository.save(flight);
    return flightRepository.findById(flight.getId()).orElseThrow(()-> new ResourceNotFoundException("Flight not found", "Flight", "id", flight.getId()));
  }

//Elimina un vuelo de la base de datos
  public void deleteFlight(Long id) throws ResourceNotFoundException {
    flightRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Flight not found", "Flight", "id", id));
    flightRepository.deleteById(id);
  }

  private double getDolar(){
    return flightConfiguration.FetchDolar().getPromedio();
  }

}
