package dtos;

import domain.Internship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyDTO {
    private Integer id;
    private List<Internship> internships;
    private String email;
    private String password;
    private String name;
}
