package com.microservice.professor.app.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.professor.app.documents.Professor;

import reactor.core.publisher.Flux;

@Repository
public interface ProfessorRepository extends ReactiveMongoRepository<Professor, String>{

	Flux<Professor> findByFirstName(String firstName);
	Flux<Professor> findByBirthdayDate(LocalDate birthdayDate);
}
