package com.promineotech.mvnFinalSpringBoot.repository;

import com.promineotech.mvnFinalSpringBoot.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient, Long> {
	List<Patient> findAll();

	Optional<Patient> findById(Long id);
}
