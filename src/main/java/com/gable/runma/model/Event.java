package com.gable.runma.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

/**
 * 
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date race_Date_time;
    @Temporal(TemporalType.DATE)
    private Date open_Regis_Date;
    @Temporal(TemporalType.DATE)
    private Date close_Regis_Date;
    private Boolean out_of_ticket_flag;
    private String province;
    private String location;
    private Integer capacity;
    
    @OneToMany (mappedBy = "event" ,fetch = FetchType.LAZY ,cascade = CascadeType.REMOVE )    
    private List<RaceType> raceTypeList;
    @ManyToMany
    @JoinTable(name = "EVENT_ORGANIZER",  joinColumns =  @JoinColumn(name = "event_id") ,
            inverseJoinColumns =  @JoinColumn(name = "organizer_id") )
    private List<Organizer> organizerList;

}