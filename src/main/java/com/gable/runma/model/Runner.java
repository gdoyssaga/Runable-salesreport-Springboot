package com.gable.runma.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Entity
public class Runner extends User{
	private String emergencyName;
	private String emergencyPhone;
	private String chronicDisease;

	@OneToMany(mappedBy = "runner")
	private List<Ticket> ticket;
}
