package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// Lombok
@NoArgsConstructor
@AllArgsConstructor
@Data
// Persistence
@Entity
@Table(name = "EDUCATIONS")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="STUDENT_ID")
    private Student student;


    @NotNull
    private EducationalDegree degree;

    @NotNull
    private String institutionName;

    @NotNull
    private String specialization;

    private String description;
}
