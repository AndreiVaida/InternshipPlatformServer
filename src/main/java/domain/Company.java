package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// Lombok
@NoArgsConstructor
//@AllArgsConstructor
@Data
// Persistence
@Entity
@Table(name = "COMPANIES")
public class Company extends User {
}
