package services;

import domain.Company;
import domain.Internship;
import dtos.FilterDTO;
import dtos.InternshipDTO;
import jdk.vm.ci.meta.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CompanyRepository;
import repositories.InternshipRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
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
        LocalDate earliestStartDate = LocalDate.parse(filterDTO.earliestStartDate),
                latestEndDate = LocalDate.parse(filterDTO.latestEndDate);

        return internships.stream().filter((i) -> industries.isEmpty() || industries.contains(i.getIndustry().toLowerCase()))
                .filter((i) -> cities.isEmpty() || cities.contains(i.getCity().toLowerCase()))
                .filter((i) -> earliestStartDate == null || earliestStartDate.isBefore(i.getStartDate()) || earliestStartDate.isEqual(i.getStartDate()))
                .filter((i) -> latestEndDate == null || latestEndDate.isAfter(i.getEndDate()) || latestEndDate.isEqual(i.getEndDate()))
                .map(Internship::asDTO).collect(Collectors.toList());
    }

    @Override
    public List<String> getCities() {
        return new ArrayList<>(internshipRepository.findAll().stream().map(Internship::getCity).collect(Collectors.toSet()));
    }

    @Override
    public List<String> getIndustries() {
        return new ArrayList<>(internshipRepository.findAll().stream().map(Internship::getIndustry).collect(Collectors.toSet()));
    }
}
