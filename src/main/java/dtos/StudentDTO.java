package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private Integer id;
    private String email; //university mail
    private String password;
    private String name;
    private List<EducationDTO> educationDTOs;
}
