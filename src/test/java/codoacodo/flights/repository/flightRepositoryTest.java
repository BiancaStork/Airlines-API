package codoacodo.flights.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import codoacodo.flights.model.Flight;

@DataJpaTest /*con esta anotacion le decimos q esta clase es para testear */
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class FlightRepositoryTest {
    @Autowired  /*inyectamos el repositorio */
    private FlightRepository flightRepository;
    
   
    private Flight flight;

    @BeforeEach /*le indico q lo va hacer esto antes que tod  */
    void setup(){
        //creo un vuelo para testear
        flight = new Flight("COR", "EZE", "8.00", "11.00", 200.0, "Diaria");
    }
    @DisplayName ("Guardar Vuelo Nuevo")
    @Test
  
    void saveFlightTest(){
        //configuracion previa en el setup -cracion del vuelo-

        // llamar a la Funcionalidad -metodo guardar vuelo (save)-
        Flight flightBD = flightRepository.save(flight);

        //verificar la salida (comportamiento)
        assertThat(flightBD).isNotNull();
        assertThat(flightBD.getId()).isGreaterThan(0); //le pregunto si el id es > 0
    }
    @Test 
    void flightFindByIdTest(){
        //configuracion previa en el setup
        
        flightRepository.save(flight);

        //llamar a la funcionalidad
        Flight flightBD = flightRepository.findById(flight.getId()).get();

        //verificar el comportamiento
        assertThat(flightBD).isNotNull();
              

    }
    @Test
    void flightFindAllTest(){
        //configuracion previa
         //creo un vuelo mas para testear
         Flight flight2 = new Flight("COR", "IGR", "8.00", "11.00", 230.0, "Diaria");

         flightRepository.save(flight);
         flightRepository.save(flight2);

        //llamar a la funcionalidad
        List<Flight> flightList= flightRepository.findAll();

        //verificar el comportamiento
        assertThat(flightList).isNotNull();
        assertThat(flightList.size()).isEqualTo(2);
    }

        @Test
        void flightDeleteByIdTest(){
          
            flightRepository.save(flight);

            //llamar a la funcionalidad
            flightRepository.deleteById(flight.getId());
            
            //verificar comportsmiento
            Optional<Flight> deletedFlight = flightRepository.findById(flight.getId());
            assertThat(deletedFlight).isEmpty();
        }

        @Test
        void flightUpdateTest(){
           
        
        flightRepository.save(flight);
        Flight flightBD = flightRepository.findById(flight.getId()).get();
        flightBD.setOrigin("BRA");
        flightBD.setDestiny("ARG");

        Flight flightUpdated = flightRepository.save(flightBD);

        //verificar comportamiento

        assertThat(flightUpdated.getOrigin()).isEqualTo("BRA");
        assertThat(flightUpdated.getDestiny()).isEqualTo("ARG");

        }




}
