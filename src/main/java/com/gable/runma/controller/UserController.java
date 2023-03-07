package com.gable.runma.controller;
import com.gable.runma.model.User;
import com.gable.runma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    User findOne(@PathVariable Integer id) {
        return service.getUser(id);
    }

    @PostMapping("/")
    public User newUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("/{id}")
    User update(@RequestBody User user, @PathVariable Integer id) {
        return service.updateUser(user, id);
    }

}
