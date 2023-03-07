package com.gable.runma.service;


import com.gable.runma.exception.DataIntegrityViolationException;
import com.gable.runma.exception.ResourceNotFoundException;
import com.gable.runma.model.Event;
import com.gable.runma.model.Ticket;
import com.gable.runma.model.User;
import com.gable.runma.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gable.runma.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private TicketRepository ticketRepo;


	//get User by Id
	public User getUser(Integer id) {
		User user = repo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User with id: " + id + " does not exist"));
		//return ResponseEntity.ok(user).getBody();
		return user;
	}

	//crete new user
	public User createUser(User user) {
		repo.save(user);
		return user;
	}


//	//อันนี้ใช้ได้
//	public User updateUser(User data) {
//		User user = repo.findById(data.getId()).orElseThrow(() -> new ResourceNotFoundException("User with id: " + data.getId() + " does not exist"));
//
//		// Check if the email already exists in the database
//		User existingUser = repo.findByEmail(data.getEmail());
//		if (existingUser != null && !existingUser.getId().equals(user.getId())) {
//			throw new DataIntegrityViolationException("The email address " + data.getEmail() + " is already taken.");
//		}
//
////		if (data != null) {
////			if (user.getTicket() != null) {
////				for (Ticket ticket : data.getTicket()) {
////					Ticket objTicket = ticketRepo.findById(ticket.getId()).orElseThrow(() -> new ResourceNotFoundException("Ticket with id: " + ticket.getId() + " does not exist"));
////					objTicket.setUserID(user);
////					user.getTicket().add(objTicket);
////					ticketRepo.save(objTicket);
////					System.out.println("noooooooooooooooooooooooooooooo");
////				}
////			}
////		}
//		System.out.println("yayyyyyyyyyyyyyyy");
//		repo.save(data);
//		return user;
//	}

	public User updateUser(User newValue, Integer userID) {
		Optional <User> old = repo.findById(userID);

		if (old.isPresent()) {
			User theOld = old.get();

			// Check if the email already exists in the database
			User existingUser = repo.findByEmail(newValue.getEmail());
			if (existingUser != null && !existingUser.getId().equals(newValue.getId())) {
				throw new DataIntegrityViolationException("The email address " + newValue.getEmail() + " is already taken.");
			} else {
				theOld.setAddress(newValue.getAddress());
				theOld.setBirthDate(newValue.getBirthDate());
				theOld.setCountry(newValue.getCountry());
				theOld.setDistrict(newValue.getDistrict());
				theOld.setEmail(newValue.getEmail());
				theOld.setFName(newValue.getFName());
				theOld.setGender(newValue.getGender());
				theOld.setLName(newValue.getLName());
				theOld.setPhone(newValue.getPhone());
				theOld.setPostalCode(newValue.getPostalCode());
				theOld.setProvince(newValue.getProvince());
				theOld.setSubDistrict(newValue.getSubDistrict());
				theOld.setPassword(newValue.getPassword());

				theOld.getTicket().clear();

				if (newValue != null) {
					theOld.getTicket().clear();
					if (newValue.getTicket() != null) {
						for (Ticket ticket : newValue.getTicket()) {
							Ticket objTicket = ticketRepo.findById(ticket.getId()).orElseThrow();
							theOld.getTicket().add(objTicket);
							if (!objTicket.getUser().equals(theOld)) {
								objTicket.setUser(theOld);
								ticketRepo.save(objTicket);
							}
						}
					}
				}
				return repo.save(theOld);
			}
		} else {
			throw new ResourceNotFoundException("Not found this user");
		}
	}

}
