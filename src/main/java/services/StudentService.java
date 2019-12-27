package services;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.EducationRepository;
import repositories.StudentRepository;
import repositories.UserRepository;

import javax.persistence.EntityExistsException;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final EducationRepository educationRepository;
    private final UserRepository userRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, EducationRepository educationRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.educationRepository = educationRepository;
        this.userRepository = userRepository;
    }

    public Student addStudent(Student newStudent){
        if(userRepository.findByEmail(newStudent.getEmail()).size() > 0){
            throw new EntityExistsException("Exista un cont cu acest mail");
        }

        Student student = new Student();
        student.setEmail(newStudent.getEmail());
        student.setPassword(newStudent.getPassword());
        student.setName(newStudent.getName());
        studentRepository.save(student);

        newStudent.getEducationList().forEach(education->{
            education.setStudent(student);
            educationRepository.save(education);
        });

        return student;
    }
}
