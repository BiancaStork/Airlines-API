package codoacodo.flights.models;


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
@Entity  //me dice que esto sera almacenado en una bd

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String origin;
    private String destiny;
    private String departureDateTime;
    private String arrivalDateTime;
    private double price; 
    private String frecuency;
    
    
    public Flight(String origin, String destiny, String departureDateTime, String arrivalDateTime, double price,
            String frecuency) {
        this.origin = origin;
        this.destiny = destiny;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.price = price;
        this.frecuency = frecuency;
    }
    
   
  

    
}


