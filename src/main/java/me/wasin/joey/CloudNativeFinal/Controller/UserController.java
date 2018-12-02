package me.wasin.joey.CloudNativeFinal.Controller;

import me.wasin.joey.CloudNativeFinal.Authentication.JwtAuthentication;
import me.wasin.joey.CloudNativeFinal.User.User;
import me.wasin.joey.CloudNativeFinal.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> user_object = userService.getAllUser();
        return new ResponseEntity<List<User>>(user_object, HttpStatus.OK);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<User> getUserById(HttpServletRequest request, @PathVariable(name = "user_id") long userId) {
        JwtAuthentication.validateToken(request.getHeader("Authorization"));
        User user_object = userService.getUserById(userId);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User user_object = userService.addUser(user);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }
}
