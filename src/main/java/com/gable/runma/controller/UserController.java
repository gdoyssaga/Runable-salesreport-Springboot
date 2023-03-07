package com.gable.runma.controller;
import com.gable.runma.model.User;
import com.gable.runma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        if (service.validateUser(user.getEmail(), user.getPassword())) {
            return ResponseEntity.ok("เข้าสู่ระบบสำเร็จ!");
        } else {
            return ResponseEntity.badRequest().body("Email หรือ Password ไม่ถูกต้อง กรุณากรอกใหม่อีกครั้ง");
        }
    }

	   /* @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody User user) {
	        User foundUser = userRepository.findByEmail(user.getEmail());
	        if (foundUser == null) {
	            return ResponseEntity.badRequest().body("Email หรือ Password ไม่ถูกต้อง กรุณากรอกใหม่อีกครั้ง");
	        }
	
	        if (!foundUser.getPassword().equals(user.getPassword())) {
	            return ResponseEntity.badRequest().body("Email หรือ Password ไม่ถูกต้อง กรุณากรอกใหม่อีกครั้ง");
	        }
	
	        return ResponseEntity.ok("เข้าสู่ระบบสำเร็จ!");
	    }

   /* @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null) {
            return ResponseEntity.badRequest().body("Email หรือ Password ไม่ถูกต้อง กรุณากรอกใหม่อีกครั้ง");
        }

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.badRequest().body("Email หรือ Password ไม่ถูกต้อง กรุณากรอกใหม่อีกครั้ง");
        }*/

    
    
    
    
    /*@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }*/


    }

