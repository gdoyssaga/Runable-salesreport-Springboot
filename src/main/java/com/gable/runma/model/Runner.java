package com.gable.runma.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Runner extends User {
	private String emergencyName;
	private String emergencyPhone;
	private String chronicDisease;
	@OneToMany(mappedBy = "runner")
	private List<Ticket> ticket;
}
