package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

// Lombok
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
//@AllArgsConstructor
@Data
// Persistence
@Entity
@Table(name = "COMPANIES")
public class Company extends User {
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @NonNull
    private List<Internship> internships;
}
