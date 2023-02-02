package com.gable.runma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gable.runma.model.Runner;

public interface RunnerRepository extends JpaRepository<Runner, Integer> {

}
