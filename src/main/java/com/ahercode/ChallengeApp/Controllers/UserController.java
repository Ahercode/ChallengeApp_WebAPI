package com.ahercode.ChallengeApp.Controllers;
import com.ahercode.ChallengeApp.Models.User;
import com.ahercode.ChallengeApp.Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService _userService;
    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return _userService.getUsers();
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        if (_userService.addUser(user))
            return "User added";
        else
            return "User not added";
    }
}
