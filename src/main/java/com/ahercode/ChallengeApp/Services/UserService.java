package com.ahercode.ChallengeApp.Services;

import com.ahercode.ChallengeApp.Models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
//    list of users
    private List<User> users = new ArrayList<>();

//    iinitialize the list of users
    public UserService() {
        users.add(new User(1L, "admin", "admiin@gmail.com", "admin", "admin"));
        users.add(new User(2L, "user", "user@gmail..com", "user", "user"));
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean addUser(User user) {
        try {
            for (User u : users) {
                if (u.getId().equals(user.getId())) {
                    return false;
                }
            }
            users.add(user);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
