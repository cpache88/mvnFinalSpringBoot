package com.promineotech.mvnFinalSpringBoot.repository;

import com.promineotech.mvnFinalSpringBoot.entity.Admission;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AdmissionRepository extends CrudRepository<Admission, Long> {
	List<Admission> findAll();

	Optional<Admission> findById(Long id);
}
