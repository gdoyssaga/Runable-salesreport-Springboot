package com.gable.runma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.model.Event;
import com.gable.runma.model.Organizer;
import com.gable.runma.repository.EventRepository;
import com.gable.runma.repository.OrganizerRepository;

@Service
public class OrganizerService {
	@Autowired
	private OrganizerRepository repo;
	@Autowired
	private EventRepository evtRepo;

	public List<Organizer> findAll() {
		return repo.findAll();
	}

	public Organizer newOrganizer(Organizer org) {
		return repo.save(org);
	}

	public Organizer updateOrganizer(Organizer newValue) {
		Organizer old = repo.findById(newValue.getId()).orElseThrow();
		old.setContact(newValue.getContact());
		old.setEmail(newValue.getEmail());
		old.setFacebook(newValue.getFacebook());
		old.setName(newValue.getName());
		old.setWebsite(newValue.getWebsite());
		
		old.getEventList().clear();
		
		for (Event event : newValue.getEventList()) {
			 System.out.println(event.getId());
			 
			 Event objEvent =  evtRepo.findById(event.getId()).orElseThrow();
			 old.getEventList().add(objEvent);
			 if (! objEvent.getOrganizerList().contains(old)) {
				 objEvent.getOrganizerList().add(old);
				 evtRepo.save(objEvent);
			 }
		}
		
		
		repo.save(old);
		return old;
	}
}
