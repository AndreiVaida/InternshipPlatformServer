package dtos;

import domain.EducationalDegree;
import domain.Student;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class EducationDTO {
    private String degree;
    private String institutionName;
    private String specialization;
    private String description;

    public EducationDTO() {
    }

    public EducationDTO(String degree, String institutionName, String specialization, String description) {
        this.degree = degree;
        this.institutionName = institutionName;
        this.specialization = specialization;
        this.description = description;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
