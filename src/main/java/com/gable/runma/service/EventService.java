package com.gable.runma.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gable.runma.dto.EventInfoResponse;
import com.gable.runma.dto.RacetypeDetailResponse;

import com.gable.runma.model.RaceType;
import com.gable.runma.model.Status;
import com.gable.runma.repository.OrganizerRepository;
import com.gable.runma.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.model.Event;
import com.gable.runma.repository.EventRepository;
import com.gable.runma.repository.RaceTypeRepository;
import com.gable.runma.exceptionHandling.EventException;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepo;
	@Autowired
	private RaceTypeRepository raceRepo;
	@Autowired
	private OrganizerRepository orgRepo;
	@Autowired
	private TicketRepository ticketRepo;

	public EventService() {
	}

	public List<Event> findAll() {
		return eventRepo.findAll();
	}

	//Need to add exception NotFound
	public Optional<Event> findOne(Integer id) {
//		return eventRepo.findById(id).orElseThrow(() -> {
//			throw new EventException("Event Not Found");
//		});
//	}
		try{
			Optional<Event> event = eventRepo.findById(id);
			if(event.isEmpty()) {
				throw new EventException("Event not found");
			} else {
				return event;
			}
		} catch (EventException e) {
			return Optional.empty();
		}
	}

	public EventInfoResponse getSalesEventInfo(Integer id){
		Event event = eventRepo.findById(id).orElseThrow();
		EventInfoResponse infoDTO = new EventInfoResponse(); //DTO

		infoDTO.setEventName(event.getName());
		infoDTO.setLocation(event.getLocation());

		List<RacetypeDetailResponse> ticketRaceTypeInfo = new ArrayList<RacetypeDetailResponse>();

		for (RaceType r : event.getRaceTypeList()) {

			RacetypeDetailResponse singleTicketRaceType = new RacetypeDetailResponse();
			singleTicketRaceType.setRaceName(r.getName());
			singleTicketRaceType.setPrice(r.getPrice());
			singleTicketRaceType.setDistance(r.getDistance());
			singleTicketRaceType.setSales(ticketRepo.findByStatusAndRaceType(Status.paid,r).size());
			ticketRaceTypeInfo.add(singleTicketRaceType);
		}

		infoDTO.setRaceTypeDetailList(ticketRaceTypeInfo);
		return  infoDTO;
	}

}
