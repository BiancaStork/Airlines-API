package codoacodo.flights.models;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor


public class FlightDto {
    private Long id;
    private String origin;
    private String destiny;
    private String departureDateTime;
    private String arrivalDateTime;
    private double convertedPrice; 
    private String frecuency;
    private Company company;


    

}
