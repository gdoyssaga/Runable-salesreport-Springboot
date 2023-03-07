package com.gable.runma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gable.runma.model.User;
import com.gable.runma.repository.UserRepository;
import com.gable.runma.service.UserService;

@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    

    
    

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        if (userService.validateUser(user.getEmail(), user.getPassword())) {
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

