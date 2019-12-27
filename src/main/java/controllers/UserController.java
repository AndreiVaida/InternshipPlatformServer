package controllers;

import domain.Student;
import domain.User;
import dtos.StudentDTO;
import dtos.UserDTO;
import mappers.StudentMapper;
import mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//        final User user = userService.sayHello();
//        final UserDTO userDTO = UserMapper.userToUserDto(user);
//        final String response = "Hello world! I am " + userDTO.getHello();

        final String response = "Hello world! I am";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
