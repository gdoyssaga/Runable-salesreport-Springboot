package com.gable.runma.repository;

import com.gable.runma.model.RaceType;
import com.gable.runma.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gable.runma.model.Ticket;

import java.util.Collection;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByStatusAndRaceType(Status status, RaceType r );

}
