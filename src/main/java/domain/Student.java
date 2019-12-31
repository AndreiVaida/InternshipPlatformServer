package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

// Lombok
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
// Persistence
@Entity
@Table(name = "STUDENTS")
public class Student extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID", unique = true, nullable = false)
    private Integer id;

//    @OneToMany(cascade = CascadeType.ALL)
    @OneToMany(mappedBy="student", cascade = CascadeType.ALL)
    private List<Education> educationList;
}
