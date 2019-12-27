package controllers;

import domain.Company;
import domain.Student;
import dtos.CompanyDTO;
import dtos.StudentDTO;
import mappers.CompanyMapper;
import mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import services.CompanyService;

@Controller
public class CompanyController extends TopController{
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(path = "/company", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addStudent(@RequestBody CompanyDTO companyDTO) {
        Company company = CompanyMapper.companyDTOToCompany(companyDTO);
        companyService.addCompany(company);

        return new ResponseEntity<>("Adaugat cu succes!", HttpStatus.OK);
    }
}
