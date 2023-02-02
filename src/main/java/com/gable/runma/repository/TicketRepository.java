package com.gable.runma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gable.runma.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
