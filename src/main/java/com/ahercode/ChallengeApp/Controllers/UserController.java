package com.ahercode.ChallengeApp.Controllers;
import com.ahercode.ChallengeApp.Models.User;
import com.ahercode.ChallengeApp.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService _userService;
    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
//        return _userService.getUsers();
        return ResponseEntity.ok(_userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {

        if (_userService.addUser(user))
            return ResponseEntity.ok("User added successfully");
        else
            return ResponseEntity.badRequest().body("Failed to add a new user");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = _userService.getUserById(id);
        if (user != null)
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        if (_userService.updateUser(id, updatedUser))
            return ResponseEntity.ok("User updated successfully");
        else
            return ResponseEntity.badRequest().body("Failed to update user");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (_userService.deleteUser(id))
            return ResponseEntity.ok("User deleted successfully");
        else
            return ResponseEntity.badRequest().body("Failed to delete user");
    }
}
