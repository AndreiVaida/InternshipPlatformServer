package controllers;

import domain.Company;
import domain.Student;
import domain.User;
import dtos.CompanyDTO;
import dtos.StudentDTO;
import mappers.CompanyMapper;
import mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@RestController
@RequestMapping("user")
public class UserController extends TopController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getPrincipal().toString(); // the email
        final User user = userService.getUserByEmail(username);

        final String response = "Hello world! I am " + user.getName();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/student")
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        Student student = StudentMapper.studentDTOToStudent(studentDTO);
        userService.addStudent(student);

        return new ResponseEntity<>("Adaugat cu succes!", HttpStatus.OK);
    }

    @PostMapping(path = "/company")
    public ResponseEntity<String> addStudent(@RequestBody CompanyDTO companyDTO) {
        Company company = CompanyMapper.companyDTOToCompany(companyDTO);
        userService.addCompany(company);

        return new ResponseEntity<>("Adaugat cu succes!", HttpStatus.OK);
    }
}
