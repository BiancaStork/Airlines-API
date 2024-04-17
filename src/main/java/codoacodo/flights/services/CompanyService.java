package codoacodo.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codoacodo.flights.models.Company;
import codoacodo.flights.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired 
    CompanyRepository companyRepository;

    public List<Company> allCompanies(){
        return companyRepository.findAll();
     
    }

    public Company companyById(Long id){
        return companyRepository.findById(id).orElse(null);
    }

    public void newCompany(Company company){
        companyRepository.save(company);
    }

    public Company updateCompany(Company company){
        companyRepository.save(company);
        return companyRepository.findById(company.getId()).orElse(null);
    }

    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }

}
