package services;

import domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CompanyRepository;
import repositories.UserRepository;

import javax.persistence.EntityExistsException;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;
    private UserRepository userRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    public Company addCompany(Company company){
        if(userRepository.findByEmail(company.getEmail()).size() > 0){
            throw new EntityExistsException("Exista un cont cu acest mail");
        }

        companyRepository.save(company);

        return company;
    }
}
