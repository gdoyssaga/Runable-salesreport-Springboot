//package com.gable.runma.dto;
//
//import com.gable.runma.model.Event;
//import com.gable.runma.model.RaceType;
//import com.gable.runma.repository.EventRepository;
//import com.gable.runma.repository.OrganizerRepository;
//import com.gable.runma.repository.RaceTypeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EventUpdateDTO {
//
//    @Autowired
//    private EventRepository eventRepo;
//    @Autowired
//    private RaceTypeRepository raceRepo;
//    @Autowired
//    private OrganizerRepository orgRepo;
//
//
//    private EventUpdateDTO(){
//
//    }
//
//    public EventUpdateDTO(Event oldEvent, Event newEvent){
//            oldEvent.setName(newEvent.getName());
//            oldEvent.setRaceDate(newEvent.getRaceDate());
//            oldEvent.setOpenRegisDate(newEvent.getOpenRegisDate());
//            oldEvent.setCloseRegisDate(newEvent.getCloseRegisDate());
//            oldEvent.setOutOfTicketFlag(newEvent.getOutOfTicketFlag());
//            oldEvent.setProvince(newEvent.getProvince());
//            oldEvent.setLocation(newEvent.getLocation());
//            oldEvent.setCapacity(newEvent.getCapacity());
//
//        //only edit , what if admin want to delete?
//            for (RaceType newRaceType : newEvent.getRaceTypeList()){
//                for(RaceType oldRaceType :oldEvent.getRaceTypeList()){
//                oldRaceType.setName();
//            }
//        }
//    }
//}
