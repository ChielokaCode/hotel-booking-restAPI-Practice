package com.danielszulc.roomreserve.controller;

import com.danielszulc.roomreserve.dto.AuthenticationResponse;
import com.danielszulc.roomreserve.dto.SignIn;
import com.danielszulc.roomreserve.dto.SignUp;
import com.danielszulc.roomreserve.model.User;
import com.danielszulc.roomreserve.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

     private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody @Valid  SignUp signUpDto){

        User res;
        res = userService.registerUser(signUpDto);

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid SignIn loginDto) {

        AuthenticationResponse res;
        res = userService.authenticateUser(loginDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
