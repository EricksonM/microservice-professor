package com.microservice.professor.app.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.microservice.professor.app.documents.Professor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface IProfessorService {

	public Flux<Professor> getAll();
	public Mono<Professor> save(Professor professor);
	public Mono<Void> deleteById(String id);
	public Mono<Professor> getById(String id);
	public Flux<Professor> getByFirstName(String firstName);
	public Flux<Professor> getByBirthdayDate(LocalDate birthdayDate);
	
}
