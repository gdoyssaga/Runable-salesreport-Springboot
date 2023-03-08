package com.gable.runma.controller;

import java.util.List;
import java.util.Optional;

import com.gable.runma.dto.EventInfoResponse;
import com.gable.runma.dto.RacetypeDetailResponse;
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
	public Optional<Event> findOne(@PathVariable Integer id){return service.findOne(id);}

	@GetMapping("/info/{id}")
	public EventInfoResponse findInfo(@PathVariable Integer id) { return  service.getSalesEventInfo(id);}



}
