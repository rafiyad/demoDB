package com.rafiyad.teamcollab.controller;

import com.rafiyad.teamcollab.model.User;
import com.rafiyad.teamcollab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
   public String userRegister(@RequestBody User register){
        return userService.userRegister(register);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        String result = userService.updateUser(id, updateUser);
        return result;
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

}


