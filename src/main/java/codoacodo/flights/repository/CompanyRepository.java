package codoacodo.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import codoacodo.flights.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{

    
} 
