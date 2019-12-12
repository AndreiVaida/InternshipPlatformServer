package controllers;

import domain.User;
import dtos.UserDTO;
import mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        final User user = userService.sayHello();
        final UserDTO userDTO = UserMapper.userToUserDto(user);
        final String response = "Hello world! I am " + userDTO.getHello();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
