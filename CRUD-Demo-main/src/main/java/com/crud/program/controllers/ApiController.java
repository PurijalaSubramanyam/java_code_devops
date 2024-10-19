package com.crud.program.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crud.program.Repo.UserRepo;
import com.crud.program.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ApiController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String homeScreen() {
        return "Welcome";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "Saved...";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User entity) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(entity.getFirstName());
        updatedUser.setAge(entity.getAge());
        updatedUser.setLastName(entity.getLastName());
        updatedUser.setOccupation(entity.getOccupation());
        userRepo.save(updatedUser);
        return "Updated user with ID - " + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deletedUser = userRepo.findById(id).get();
        userRepo.delete(deletedUser);
        return "Deleted user with ID - " + id;
    }
    
}
