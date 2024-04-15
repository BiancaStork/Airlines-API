package codoacodo.flights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import codoacodo.flights.models.Flight;
import codoacodo.flights.models.FlightDto;
import codoacodo.flights.services.FlightService;


import java.util.List;

@RestController
@RequestMapping("/flights")

public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping()
    public List<FlightDto> getAll(){
        return flightService.allFlights();
    }

    @GetMapping("/{id}")
    public Flight getById(@PathVariable Long id){
        return flightService.flightById(id);
    }
    
    @GetMapping("/offers")
    public List<Flight> getByPrice(@RequestParam Integer price)    {
        return flightService.getOffers(price);
    }

    @PostMapping("/new")
    public void saveNew(@RequestBody Flight flight) {       
        flightService.newFlight(flight);
    }
    @PutMapping("/update")
    public Flight update(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }

   @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {               
       flightService.deleteFlight(id);
    }
    
    @GetMapping("/cotizacion-dolar")
    public double getDolar() {
        return flightService.getDolar();
    }
    
}
