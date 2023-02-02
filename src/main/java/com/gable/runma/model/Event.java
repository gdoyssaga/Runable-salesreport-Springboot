package com.gable.runma.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String location;
	private String tag;
	@Temporal(TemporalType.DATE)
	private Date raceDate;
	@Temporal(TemporalType.DATE)
	private Date openRegisDate;
	@Temporal(TemporalType.DATE)
	private Date closeRegisDate;
	
	@OneToMany(mappedBy = "event")
	private List<RaceType> raceType;
	
	@ManyToMany
	private List<Organizer> organizer;
}
