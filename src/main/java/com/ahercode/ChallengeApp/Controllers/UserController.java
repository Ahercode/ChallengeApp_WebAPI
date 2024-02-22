package com.ahercode.ChallengeApp.Controllers;
import com.ahercode.ChallengeApp.Models.User;
import com.ahercode.ChallengeApp.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService _userService;
    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
//        return _userService.getUsers();
        return ResponseEntity.ok(_userService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {

        if (_userService.addUser(user))
            return ResponseEntity.ok("User added successfully");
        else
            return ResponseEntity.badRequest().body("Failed to add a new user");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = _userService.getUserById(id);
        if (user != null)
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.notFound().build();
    }
}
