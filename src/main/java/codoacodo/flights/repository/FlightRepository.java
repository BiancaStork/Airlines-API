package codoacodo.flights.repository;

 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import codoacodo.flights.models.Flight;




 @Repository

 public interface FlightRepository extends JpaRepository<Flight,Long> {  

 }
