package com.gable.runma.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gable.runma.dto.TicketRequest;
import com.gable.runma.model.Ticket;
import com.gable.runma.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService service;
	
	@PostMapping("")
	public ResponseEntity<Ticket> create(@Valid @RequestBody TicketRequest req) {
		return new ResponseEntity<Ticket>(service.create(req), HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}")
	public List<Ticket> searchByUser(@PathVariable Integer userId){
		return service.findUserTicket(userId);
	}


        //get all tickets
        @GetMapping("/")
         public List<Ticket> findAll(){
        return service.findAll();
    }

        @GetMapping("/{id}")
        Ticket findOne(@PathVariable Integer id) {
            return service.getTicket(id);
        }

        
}
