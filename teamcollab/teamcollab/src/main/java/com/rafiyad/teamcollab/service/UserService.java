package com.rafiyad.teamcollab.service;

import com.rafiyad.teamcollab.model.User;
import com.rafiyad.teamcollab.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public String happy() {
        return "I am Happy";
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public String userRegister(User user) {
        userRepo.save(user);
        return "Success";
    }

    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }
    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "User deleted";
    }

    public String updateUser(Long id, User updateUser) {
        Optional<User> optionalUser = userRepo.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Update fields based on what is provided in the updateUser object
            if (updateUser.getUsername() != null) {
                existingUser.setUsername(updateUser.getUsername());
            }
            if (updateUser.getEmail() != null) {
                existingUser.setEmail(updateUser.getEmail());
            }
            if (updateUser.getPassword() != null) {
                existingUser.setPassword(updateUser.getPassword());
            }
            if (updateUser.getFirstName() != null) {
                existingUser.setFirstName(updateUser.getFirstName());
            }
            if (updateUser.getLastName() != null) {
                existingUser.setLastName(updateUser.getLastName());
            }

            // Save the updated user
            userRepo.save(existingUser);
            return "User updated successfully";
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

}