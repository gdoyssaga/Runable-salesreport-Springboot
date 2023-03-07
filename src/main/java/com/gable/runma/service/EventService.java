package com.gable.runma.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gable.runma.dto.EventInfoResponse;
import com.gable.runma.dto.RacetypeDetailResponse;

import com.gable.runma.model.RaceType;
import com.gable.runma.repository.OrganizerRepository;
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

	public EventInfoResponse getEventInfo(Integer id){
		Event event = eventRepo.findById(id).orElseThrow();
		EventInfoResponse info = new EventInfoResponse();

		info.setEventName(event.getName());
		info.setLocation(event.getLocation());

		List<RacetypeDetailResponse> newraceTypeList = new ArrayList<>();
		List<RacetypeDetailResponse> oldraceTypelist;

		for (RaceType r : event.getRaceTypeList()) {
//					newraceTypeList.set
		}
//
//
//		for (int i = 0; i < event.getRaceTypeList().size(); i++) {
//			newraceTypeList.set();
//		}

//		info.setRaceTypeDetailList(newraceTypeList);

		return  info;
	}










}
