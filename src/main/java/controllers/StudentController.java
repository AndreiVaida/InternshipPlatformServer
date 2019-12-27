package controllers;

import domain.Student;
import dtos.StudentDTO;
import mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import services.StudentService;

@Controller
public class StudentController extends TopController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/student", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
            Student student = StudentMapper.studentDTOToStudent(studentDTO);
            studentService.addStudent(student);

            return new ResponseEntity<>("Adaugat cu succes!", HttpStatus.OK);
    }
}
