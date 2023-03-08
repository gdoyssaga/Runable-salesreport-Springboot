package com.gable.runma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gable.runma.model.Organizer;
import com.gable.runma.service.OrganizerService;

@RestController
@RequestMapping("/organizer")
public class OrganizerController {

	@Autowired
	private OrganizerService service ;
	
	@GetMapping("/")
	public List<Organizer> findAll(){
		return  service.findAll();
	}
	@PostMapping("/")
	public Organizer newOrganizer(@RequestBody Organizer org) {
		return service.newOrganizer(org);
	}
	
	@PutMapping("/{id}")
	public Organizer updateOrganizer(@RequestBody Organizer org) {
		return service.updateOrganizer(org);
	}
	
	

	//getOrganizer
	@GetMapping("/{id}")
	Organizer findOne(@PathVariable Integer id) {
		return service.getOrganizer(id);
	}
}
