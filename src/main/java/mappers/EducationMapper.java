package mappers;

import domain.Education;
import dtos.EducationDTO;

public class EducationMapper {
    public static EducationDTO educationToEducationDTO(final Education education) {
        final EducationDTO dto = new EducationDTO();
        dto.setDegree(education.getDegree());
        dto.setDescription(education.getDescription());
        dto.setInstitutionName(education.getInstitutionName());
        dto.setSpecialization(education.getSpecialization());
        return dto;
    }

    public static Education educationDTOToEducation(final EducationDTO dto){
        final Education education = new Education();
        education.setDegree(dto.getDegree());
        education.setDescription(dto.getDescription());
        education.setInstitutionName(dto.getInstitutionName());
        education.setSpecialization(dto.getSpecialization());
        return education;
    }
}
