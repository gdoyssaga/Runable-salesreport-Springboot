package com.gable.runma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.dto.TicketRequest;
import com.gable.runma.exception.RaceTypeNotFoundException;
import com.gable.runma.exception.UserNotFoundException;
import com.gable.runma.model.RaceType;
import com.gable.runma.model.Status;
import com.gable.runma.model.Ticket;
import com.gable.runma.model.User;
import com.gable.runma.repository.RaceTypeRepository;
import com.gable.runma.repository.TicketRepository;
import com.gable.runma.repository.UserRepository;

@Service
public class TicketService {
	
	@Autowired
	private RaceTypeRepository raceTypeRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TicketRepository ticketRepo;
	
	public Ticket create(TicketRequest req) {
		
		Ticket ticket = new Ticket();
		
		RaceType rt = raceTypeRepo.findById(req.raceTypeId())
				.orElseThrow(() -> new RaceTypeNotFoundException("The RaceType Not Exist"));
		User user = userRepo.findById(req.userId())
				.orElseThrow(() -> new UserNotFoundException("The User Not Exist"));
		
		ticket.setCreateDate(req.createDate());
		ticket.setStatus(Status.unpaid);
		ticket.setRaceType(rt);
		ticket.setUser(user);
		
		return ticketRepo.save(ticket);
		
	}
	
	public List<Ticket> findAll() {
		return ticketRepo.findAll();
	}
}
