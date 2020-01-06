package dtos;

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
    private String name;
    private String city;
    private String industry;
    private String startDate;
    private String endDate;
    private String description;

    public Internship asEntity() {
        LocalDate start = LocalDate.parse(startDate), end = LocalDate.parse(endDate);
        return new Internship(id, name, city, industry, start, end, description);
    }
}
