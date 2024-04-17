package codoacodo.flights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codoacodo.flights.services.CompanyService;
import codoacodo.flights.models.Company;

import java.util.List;

@RestController
@RequestMapping("/company")

public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @CrossOrigin

    @GetMapping("")
    public List<Company> getAll(){
        return companyService.allCompanies();

    }
    @GetMapping("/{id}")
    public Company getById(@PathVariable Long id){
        return companyService.companyById(id);
    }
    @PostMapping("/new")
    public void saveNew(@RequestBody Company company) {       
        companyService.newCompany(company);
    }
    @PutMapping("/update")
    public Company update(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

   @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {               
       companyService.deleteCompany(id);
    }








}
