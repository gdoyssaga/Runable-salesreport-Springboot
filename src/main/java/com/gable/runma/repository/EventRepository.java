package com.gable.runma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gable.runma.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
