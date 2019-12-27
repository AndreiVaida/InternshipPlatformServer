package dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;

public class StudentDTO {
    private Integer id;

    private String email; //university mail

    private String password;

    private String name;

    private List<EducationDTO> educationDTOs;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String email, String password, String name, List<EducationDTO> educationDTOs) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.educationDTOs = educationDTOs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EducationDTO> getEducationDTOs() {
        return educationDTOs;
    }

    public void setEducationDTOs(List<EducationDTO> educationDTOs) {
        this.educationDTOs = educationDTOs;
    }
}
