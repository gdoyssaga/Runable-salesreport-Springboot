package com.gable.runma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.model.Event;
import com.gable.runma.model.RaceType;
import com.gable.runma.repository.EventRepository;
import com.gable.runma.repository.RaceTypeRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository repo;
	@Autowired
	private RaceTypeRepository rtRepo;

	public List<Event> findAll() {
		return repo.findAll();
	}

	public Event createEvent(Event event) {
		Event e = repo.save(event);
		if (event.getRaceType() != null) {
			for (RaceType rt : event.getRaceType()) {
				rt.setEvent(event);
				rtRepo.save(rt);
			}
			
		}
		
		return repo.save(event);
	}

}
