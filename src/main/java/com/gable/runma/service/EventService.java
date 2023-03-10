package com.gable.runma.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.gable.runma.dto.EventInfoResponse;
import com.gable.runma.dto.RacetypeDetailResponse;
import com.gable.runma.exceptionHandling.EventException;

import com.gable.runma.model.RaceType;
import com.gable.runma.model.Status;
import com.gable.runma.repository.OrganizerRepository;
import com.gable.runma.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.model.Organizer;
import com.gable.runma.model.RaceType;
import com.gable.runma.model.Event;
import com.gable.runma.repository.OrganizerRepository;
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

	public List<Event> getAllEvent() {
		return eventRepo.findAll();
	}

	public List<Event> findByOrg(int Orgid) {
		List<Event> allEvents = eventRepo.findAll();
		Organizer Org = orgRepo.findById(Orgid).orElseThrow();
		List<Event> result = new ArrayList<Event>();
		for (Event event : allEvents) {
			if (event.getOrganizerList().contains(Org)) {
				result.add(event);
			}

		}

		return result;

	}

	public List<Event> findAll() {
		return eventRepo.findAll();
	}

	public Optional<Event> findOne(Integer id) {
		try {
			Optional<Event> event = eventRepo.findById(id);
			if (event.isEmpty()) {
				throw new EventException("Event not found");
			} else {
				return event;
			}
		} catch (EventException e) {
			return Optional.empty();
		}
	}



	public Event newEvent(Event event) {
		Event e = eventRepo.save(event);
		if (event.getRaceTypeList() != null) {
			for (RaceType rt : event.getRaceTypeList()) {
				rt.setEvent(e);
				raceRepo.save(rt);
			}
		}
		if (event.getOrganizerList() != null) {
		}
		return eventRepo.save(event);
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
