package services;

import domain.Internship;
import dtos.FilterDTO;
import dtos.InternshipDTO;

import java.util.List;

public interface InternshipService {
    Internship getInternship(Integer id);
    void createInternship(InternshipDTO internshipDTO);
    List<InternshipDTO> getInternships(FilterDTO filterDTO);
}
