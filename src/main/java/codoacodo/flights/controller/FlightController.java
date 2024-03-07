package codoacodo.flights.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codoacodo.flights.model.Flight;

@RestController
@RequestMapping("/flights")

public class FlightController {

    Flight flight1 = new Flight();

    @GetMapping
    public Flight hello() {
        return flight1;
        //return ("Hi! I'm Bianca");
    }

}
