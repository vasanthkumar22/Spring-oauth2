package com.example.userauth.oauth2.api;

import com.example.userauth.oauth2.model.User;
import com.example.userauth.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){

        User user = userService.findUserByUsername(username);
        if(user == null){
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user){
        return new ResponseEntity<User>(userService.register(user), HttpStatus.CREATED);
    }
}
