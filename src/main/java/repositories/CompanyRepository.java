package repositories;

import domain.Company;
import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    List<Company> findByEmail(String email);
}
