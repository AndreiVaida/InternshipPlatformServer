package services;

import domain.Company;
import domain.Student;
import domain.User;

public interface UserService {
    User getUserByEmail(String email);
    Student addStudent(Student newStudent);
    Company addCompany(Company company);
}
