package domain;

import dtos.InternshipDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
// Persistence
@Entity
@Table(name = "INTERNSHIPS")
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    @NonNull
    private Company company;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String city;

    @Column
    @NonNull
    private String industry;

    @Column
    @NonNull
    private LocalDate startDate;

    @Column
    @NonNull
    private LocalDate endDate;

    @Column(columnDefinition="TEXT")
    private String description;

    public InternshipDTO asDTO() {
        return new InternshipDTO(id, company.getId(), name, city, industry, startDate.toString(), endDate.toString(), description);
    }
}
