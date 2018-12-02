package me.wasin.joey.CloudNativeFinal.Controller;

import me.wasin.joey.CloudNativeFinal.User.User;
import me.wasin.joey.CloudNativeFinal.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register/ticket")
    public ResponseEntity<User> userPurchaseTicket(@RequestBody HashMap registerDetail) {
        return new ResponseEntity<User>(userService.purchaseTicket(registerDetail), HttpStatus.CREATED);
    }
}
