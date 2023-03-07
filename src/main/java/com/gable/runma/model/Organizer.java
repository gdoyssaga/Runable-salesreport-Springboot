package com.gable.runma.model;
import java.util.*;

<<<<<<< Upstream, based on origin/master
=======

>>>>>>> 76cebeb merge from suebkwan
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

/**
 * 
 */
@Data
@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Organizer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private Integer password;
	private String name;
    private String contact;
    private String website;
    private String facebook;
    @Column(unique = true)
    private String email;
    
    
    @ManyToMany(mappedBy = "organizerList")
    private List<Event> eventList;


}