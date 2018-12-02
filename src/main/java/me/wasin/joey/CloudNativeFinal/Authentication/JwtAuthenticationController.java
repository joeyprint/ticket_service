package me.wasin.joey.CloudNativeFinal.Authentication;

import me.wasin.joey.CloudNativeFinal.User.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class JwtAuthenticationController {

    @GetMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if(user.getUsername().equals("59130500081") && user.getPassword().equals("test")) {
            return new ResponseEntity<String>(JwtAuthentication.createToken(user), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Not Found Any User", HttpStatus.NOT_FOUND);
    }

}
