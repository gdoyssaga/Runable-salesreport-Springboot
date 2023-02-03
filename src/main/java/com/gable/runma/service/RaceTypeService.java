package com.gable.runma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gable.runma.repository.RaceTypeRepository;

@Service
public class RaceTypeService {
	@Autowired
	private RaceTypeRepository repo;
}
