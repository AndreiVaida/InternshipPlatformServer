package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

// Lombok
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
//@AllArgsConstructor
@Data
// Persistence
@Entity
@Table(name = "COMPANIES")
public class Company extends User {
}
