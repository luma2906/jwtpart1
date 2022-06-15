package com.example.mapstruct.controllers.user;
import com.example.mapstruct.model.User;
import com.example.mapstruct.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final IUserService userService;

    public UserController(@Autowired IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByEmail(email));
    }
}
