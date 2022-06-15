package com.example.mapstruct.controllers.auth;

import com.example.mapstruct.controllers.security.JWTGenerate;
import com.example.mapstruct.exception.InvalidCredentialsException;
import com.example.mapstruct.model.User;
import com.example.mapstruct.service.users.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JWTGenerate jwtGenerate;
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody  AuthenticationRequest request){
        User user = userService.findByEmail(request.getEmail());
        String jwt = "";
        if(BCrypt.checkpw(request.getPassword(),user.getPasswordHash())){
            jwt = jwtGenerate.generateToken(user);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }else {
            throw new InvalidCredentialsException();

        }
    }


}
