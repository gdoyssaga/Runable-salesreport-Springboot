package com.gable.runma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

}
