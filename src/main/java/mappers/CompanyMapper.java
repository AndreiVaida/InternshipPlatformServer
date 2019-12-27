package mappers;

import domain.Company;
import dtos.CompanyDTO;

public class CompanyMapper {
    public static CompanyDTO companyToCompanyDTO(Company company){
        CompanyDTO dto = new CompanyDTO();
        dto.setId(company.getId());
        dto.setEmail(company.getEmail());
        dto.setPassword(company.getPassword());
        dto.setName(company.getName());
        return dto;
    }

    public static Company companyDTOToCompany(CompanyDTO dto){
        Company company = new Company();
        company.setId(dto.getId());
        company.setEmail(dto.getEmail());
        company.setPassword(dto.getPassword());
        company.setName(dto.getName());
        return company;
    }
}
