package com.microservice.professor.app.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.professor.app.documents.Professor;
import com.microservice.professor.app.repositories.ProfessorRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfessorServiceImpl implements IProfessorService {

	@Autowired
	private ProfessorRepository _professorRepo;
	
	@Override
	public Flux<Professor> getAll() {
		return _professorRepo.findAll();
	}

	@Override
	public Mono<Professor> save(Professor professor) {
		return _professorRepo.save(professor);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return _professorRepo.deleteById(id);
	}
	
	@Override
	public Mono<Professor> getById(String id) {
		return _professorRepo.findById(id);
	}

	@Override
	public Flux<Professor> getByFirstName(String firstName) {
		return _professorRepo.findByFirstName(firstName);
	}

	@Override
	public Flux<Professor> getByBirthdayDate(LocalDate birthdayDate) {
		return _professorRepo.findByBirthdayDate(birthdayDate);
	}



}
