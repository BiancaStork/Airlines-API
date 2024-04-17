package codoacodo.flights.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import codoacodo.flights.models.Company;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CompanyRepositoryTest {
    @Autowired
    private CompanyRepository companyRepository;

    private Company company;

    @BeforeEach
    void setup(){
        company = new Company("Aerolineas Argentinas", "AA");

    }
    @Test
    void saveCompanyTest(){
        //configuracion previa -- en setup

        //llamar a la funcionalidad
        Company companyBD=companyRepository.save(company);

        //verifico el comportamiento
        assertThat(companyBD).isNotNull();
        assertThat(companyBD.getId()).isGreaterThan(0);
    }

    @Test 
    void companyFindByIdTest(){
        
        //configuracion previa
        companyRepository.save(company);

        //llamar a la funcionalidad
        Company companyBD = companyRepository.findById(company.getId()).get();

        //verificar el comportamiento
        assertThat(companyBD).isNotNull();

    }

    @Test
    void companyFindAllTest(){
        //configuracion previa
        Company company2 = new Company("Gol", "GOL");

         companyRepository.save(company);
         companyRepository.save(company2);

        //llamar a la funcionalidad
        List<Company> companies= companyRepository.findAll();

        //verificar el comportamiento
        assertThat(companies).isNotNull();
        assertThat(companies.size()).isEqualTo(2);
    }


    @Test
    void companyUpdateTest(){
       companyRepository.save(company);
       Company companyBD = companyRepository.findById(company.getId()).get();
       companyBD.setName("Gol Lineas Aereas");
       companyBD.setBanner("GOL");

    Company companyUpdated = companyRepository.save(companyBD);

    //verificar comportamiento

    assertThat(companyUpdated.getName()).isEqualTo("Gol Lineas Aereas");
    assertThat(companyUpdated.getBanner()).isEqualTo("GOL");

    }
    
    @Test
    void companyDeleteByIdTest(){
      
        companyRepository.save(company);

        //llamar a la funcionalidad
        companyRepository.deleteById(company.getId());
        
        //verificar comportamiento
        Optional<Company> deleted = companyRepository.findById(company.getId());
        assertThat(deleted).isEmpty();
    }






}
