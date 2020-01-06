package services;

import domain.Company;
import domain.Internship;
import dtos.FilterDTO;
import dtos.InternshipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CompanyRepository;
import repositories.InternshipRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InternshipServiceImpl implements InternshipService {
    private final InternshipRepository internshipRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public InternshipServiceImpl(InternshipRepository internshipRepository, CompanyRepository companyRepository) {
        this.internshipRepository =
                internshipRepository;
        this.companyRepository = companyRepository;
    }


    @Transactional
    @Override
    public Internship getInternship(Integer id) {
        return internshipRepository.getOne(id);
    }

    @Override
    public void createInternship(InternshipDTO internshipDTO) {
        Company company = companyRepository.getOne(internshipDTO.getCompanyId());
        LocalDate start = LocalDate.parse(internshipDTO.getStartDate()), end = LocalDate.parse(internshipDTO.getEndDate());
        Internship internship = new Internship(internshipDTO.getId(), company, internshipDTO.getName(),
                internshipDTO.getCity(), internshipDTO.getIndustry(), start, end, internshipDTO.getDescription());

        internshipRepository.save(internship);
    }

    @Override
    public List<InternshipDTO> getInternships(FilterDTO filterDTO) {
        List<Internship> internships = internshipRepository.findAll();

        List<String> industries = filterDTO.industries.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String> cities = filterDTO.cities.stream().map(String::toLowerCase).collect(Collectors.toList());
        LocalDate earliestStartDate = null;
        LocalDate latestEndDate = null;
        if (filterDTO.earliestStartDate != null) earliestStartDate = LocalDate.parse(filterDTO.earliestStartDate);
        if (filterDTO.latestEndDate != null) latestEndDate = LocalDate.parse(filterDTO.latestEndDate);

        LocalDate finalEarliestStartDate = earliestStartDate;
        LocalDate finalLatestEndDate = latestEndDate;
        return internships.stream().filter((i) -> industries.isEmpty() || industries.contains(i.getIndustry().toLowerCase()))
                .filter((i) -> cities.isEmpty() || cities.contains(i.getCity().toLowerCase()))
                .filter((i) -> finalEarliestStartDate == null || finalEarliestStartDate.isBefore(i.getStartDate()) || finalEarliestStartDate.isEqual(i.getStartDate()))
                .filter((i) -> finalLatestEndDate == null || finalLatestEndDate.isAfter(i.getEndDate()) || finalLatestEndDate.isEqual(i.getEndDate()))
                .map(Internship::asDTO).collect(Collectors.toList());
    }
}
