package dtos;

import domain.EducationalDegree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class EducationDTO {
    private EducationalDegree degree;
    private String institutionName;
    private String specialization;
    private String description;
}
