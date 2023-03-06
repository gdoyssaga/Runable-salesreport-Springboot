package com.gable.runma.model;
import java.util.*;

import javax.persistence.*;

import lombok.Data;

/**
 * 
 */
@Data
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    private Status status;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidDate;
    private String bankName;
    private Integer amount;
    private String imageProof;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="raceId", nullable = false)
    private RaceType raceType;
    
    

}