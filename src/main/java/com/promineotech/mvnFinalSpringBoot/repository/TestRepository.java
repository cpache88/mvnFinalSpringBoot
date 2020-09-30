package com.promineotech.mvnFinalSpringBoot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.promineotech.mvnFinalSpringBoot.entity.Test;

public interface TestRepository extends CrudRepository<Test, Long> {

	Optional<Test> findById(Long id);

}
