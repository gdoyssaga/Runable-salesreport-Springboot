package com.gable.runma.controller;

import com.gable.runma.model.User;
import com.gable.runma.repository.UserRepository;
import com.gable.runma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	User findOne(@PathVariable Integer id) {
		return userService.getUser(id);
	}

	@PostMapping("/")
	public User newUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{id}")
	User update(@RequestBody User user, @PathVariable Integer id) {
		return userService.updateUser(user, id);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		if (userService.validateUser(user.getEmail(), user.getPassword())) {
			return ResponseEntity.ok("เข้าสู่ระบบสำเร็จ!");
		} else {
			return ResponseEntity.badRequest().body("Email หรือ Password ไม่ถูกต้อง กรุณากรอกใหม่อีกครั้ง");
		}
	}

}
