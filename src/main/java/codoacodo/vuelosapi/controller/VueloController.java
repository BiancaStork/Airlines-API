package codoacodo.vuelosapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/vuelos")



public class VueloController {
    @GetMapping
	public String hello(){
        return("Hello World");
	}
    
}
