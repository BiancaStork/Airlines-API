package codoacodo.flights.models;

import lombok.Data;

@Data

public class FlightDto {
    private Long id;
    private String origin;
    private String destiny;
    private String departureDateTime;
    private String arrivalDateTime;
    private double convertedPrice; 

}
