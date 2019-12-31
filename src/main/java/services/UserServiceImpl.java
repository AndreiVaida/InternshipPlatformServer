package services;

import domain.Company;
import domain.Student;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import repositories.CompanyRepository;
import repositories.EducationRepository;
import repositories.StudentRepository;
import repositories.UserRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;
    private final EducationRepository educationRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, StudentRepository studentRepository, CompanyRepository companyRepository, EducationRepository educationRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.companyRepository = companyRepository;
        this.educationRepository = educationRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User sayHello() {
        final User user = new Company();
        userRepository.save(user);
        return user;
    }

    public Student addStudent(Student newStudent){
        if(userRepository.existsByEmail(newStudent.getEmail())){
            throw new EntityExistsException("Exista un cont cu acest mail");
        }

        Student student = new Student();
        student.setEmail(newStudent.getEmail());
        student.setPassword(bCryptPasswordEncoder.encode(newStudent.getPassword()));
        student.setName(newStudent.getName());

        studentRepository.save(student);

        newStudent.getEducationList().forEach(education->{
            education.setStudent(student);
            educationRepository.save(education);
        });

        return student;
    }

    public Company addCompany(Company company){
        if(userRepository.existsByEmail(company.getEmail())){
            throw new EntityExistsException("Exista un cont cu acest mail");
        }
        company.setPassword(bCryptPasswordEncoder.encode(company.getPassword()));
        companyRepository.save(company);

        return company;
    }


    public User getUserByEmail(String email){
        User user = userRepository.getByEmail(email);
        if (user == null) {
            throw new EntityNotFoundException("Nu exista un cont cu acest mail.");
        }
        return user;
    }
}
