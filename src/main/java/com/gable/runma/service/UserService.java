package com.gable.runma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.model.User;
import com.gable.runma.model.Event;
import com.gable.runma.model.Organizer;
import com.gable.runma.repository.UserRepository;
import com.gable.runma.repository.OrganizerRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private OrganizerRepository orgRepo;
	
//	public UserService() {
//		System.out.println("UserService constructor called. repo: " + repo + ", orgRepo: " + orgRepo);
//	}


	

	public boolean validateUser(String email, String password) {
		User existinguser = repo.findByEmail(email);
		if (existinguser != null && existinguser.getPassword().equals(password)) {
			return true;
		}else
		return false;
	}
	
//	public User validateUser(User usr) {
//		User existinguser = repo.findByEmail(usr.getEmail());
//		if (existinguser != null && existinguser.getEmail().equals(usr.getEmail()) & existinguser.getPassword().equals(usr.getPassword())) {
//			return usr;
//		}
//		return usr;
	}


