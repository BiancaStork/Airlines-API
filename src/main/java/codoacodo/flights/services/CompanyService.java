package codoacodo.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codoacodo.flights.exceptions.ResourceNotFoundException;
import codoacodo.flights.models.Company;
import codoacodo.flights.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired 
    CompanyRepository companyRepository;

    public List<Company> allCompanies(){
        return companyRepository.findAll();
     
    }

    public Company companyById(Long id) throws ResourceNotFoundException{
        return companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Company not found", "Company", "id", id));
    }

    public void newCompany(Company company){
        companyRepository.save(company);
    }

    public Company updateCompany(Company company) throws ResourceNotFoundException{
        companyRepository.save(company);
        return companyRepository.findById(company.getId()).orElseThrow(()-> new ResourceNotFoundException("Company not found", "Company", "id", company.getId()));
    }

    public void deleteCompany(Long id) throws ResourceNotFoundException{
        companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Company not found", "Company", "id", id));
        companyRepository.deleteById(id);
    }

}
