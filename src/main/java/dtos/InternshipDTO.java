package dtos;

import domain.Company;
import domain.Internship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InternshipDTO {
    private Integer id;
    private Integer companyId;
    private String name;
    private String city;
    private String industry;
    private String startDate;
    private String endDate;
    private String description;
}
