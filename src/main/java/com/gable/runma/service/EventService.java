package com.gable.runma.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.model.Organizer;
import com.gable.runma.model.RaceType;
import com.gable.runma.model.Event;
import com.gable.runma.repository.EventRepository;
import com.gable.runma.repository.OrganizerRepository;
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

	public Optional<Event> findOne(Integer id) {
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

	public Event update(Event newEvent) {
		Event oldEvent;
		oldEvent = eventRepo.findById(newEvent.getId()).orElseThrow(
				() -> {throw new EventException("Update Fail : Event Not Found");}
		);

		oldEvent.setName(newEvent.getName());
		oldEvent.setRaceDate(newEvent.getRaceDate());
		oldEvent.setOpenRegisDate(newEvent.getOpenRegisDate());
		oldEvent.setCloseRegisDate(newEvent.getCloseRegisDate());
		oldEvent.setOutOfTicketFlag(newEvent.getOutOfTicketFlag());
		oldEvent.setProvince(newEvent.getProvince());
		oldEvent.setLocation(newEvent.getLocation());
		oldEvent.setCapacity(newEvent.getCapacity());

		if(newEvent.getRaceTypeList() != null) {
			List<RaceType> pendingRaceType = new ArrayList<RaceType>();
			pendingRaceType.addAll(newEvent.getRaceTypeList());
			oldEvent.setRaceTypeList(pendingRaceType);
		} else
		{
			oldEvent.setRaceTypeList(null);
		}
		if(newEvent.getOrganizerList() != null) {
			List <Organizer> pendingOrg = new ArrayList<Organizer>();
			for (Organizer newOrg : newEvent.getOrganizerList()) {
				try{
					Optional<Organizer> findOrg = orgRepo.findById(newOrg.getId());
					if(findOrg.isEmpty()) {
						throw new EventException("Update Fail : Organizer not found");
					} else {
						pendingOrg.add(newOrg);
					}
				} catch (EventException e) {
					System.out.println("Update Fail : Organizer not found"+e);
				}
			}
			oldEvent.setOrganizerList(pendingOrg);
		} else
		{
			oldEvent.setOrganizerList(null);
		}

		oldEvent.getRaceTypeList().clear();
		eventRepo.save(oldEvent);

		if(newEvent.getRaceTypeList() != null) {
			for(RaceType requestRaceType: newEvent.getRaceTypeList()){
				requestRaceType.setEvent(oldEvent);
				raceRepo.save(requestRaceType);
			}
			//oldEvent.setRaceTypeList(newRestType);
		}

		return eventRepo.save(oldEvent);
	}

}
