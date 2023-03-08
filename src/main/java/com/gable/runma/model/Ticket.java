package com.gable.runma.model;
import java.util.*;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    private Status status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidDate;
    private String bankName;
    private Integer amount;
    private String imageProof;

    @ManyToOne
    @JoinColumn(name = "userTicketId", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "race_ticket_id")
    private RaceType raceType;
}