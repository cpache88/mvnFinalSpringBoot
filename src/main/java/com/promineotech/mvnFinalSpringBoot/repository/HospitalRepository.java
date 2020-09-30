package com.promineotech.mvnFinalSpringBoot.repository;

import com.promineotech.mvnFinalSpringBoot.entity.Hospital;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Long> {

	Optional<Hospital> findById(Long id);

}
