package com.gable.runma.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Username;
	private String password;
	private String FName;
	private String LName;
	private String email;
	private String phone;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	private String address;
	private String country;
	private String province;
	private String subDistrict;
	private String District;
	private int postalCode;
	@ManyToOne
	private Nationality national;
	
}
