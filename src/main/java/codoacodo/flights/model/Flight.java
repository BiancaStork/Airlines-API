package codoacodo.flights.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String origin;
    private String destination;
    private String departureDateTime;
    private String arrivalDateTime;
    private double price; 
    private String frecuency;
    
   
  

    
}


