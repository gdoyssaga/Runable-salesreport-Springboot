package com.gable.runma.controller;

import java.util.List;
import java.util.Optional;

import com.gable.runma.dto.EventInfoResponse;
import com.gable.runma.dto.RacetypeDetailResponse;
import com.gable.runma.dto.EventInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gable.runma.model.Event;
import com.gable.runma.model.RaceType;
import com.gable.runma.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	private EventService service;
	
	@GetMapping("/")
	public List<Event> findAll(){
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Event> findOne(@PathVariable Integer id) {
		return service.findOne(id);
	}

	@GetMapping("/organizer/{id}")
	public List<Event> getByOrg(@PathVariable Integer id) {
		return service.findByOrg(id);
	}

	@PostMapping("/")
	public Event newEvent(@RequestBody Event event) {
		return service.newEvent(event);
	}

	@PutMapping("/{id}")
	public Event update(@RequestBody Event event, @PathVariable Integer id) {
		return service.update(event);
	}

//	@DeleteMapping("/{id}")
//	void delete(@PathVariable Integer id) {
//		service.delete(id);
//	}
	
//	@PostMapping("/raceType/")
//	public RaceType newRaceType(@RequestBody RaceType raceType){
//		return service.newRaceType(raceType);
//	}

	@GetMapping("/info/{id}")
	public EventInfoResponse findInfo(@PathVariable Integer id) { return  service.getSalesEventInfo(id);}



}
