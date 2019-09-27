package com.microservice.professor.app.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.professor.app.documents.Professor;
import com.microservice.professor.app.services.ProfessorServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProfessorController {

	@Autowired
	private ProfessorServiceImpl _professorService;
	
	@GetMapping("/")
	public ResponseEntity<Flux<Professor>> getAll(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_professorService.getAll());
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mono<Professor>> create(@RequestBody Professor professor){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_professorService.save(professor));
	}
	
	@PutMapping("/update/{id}")
	
	public ResponseEntity<Mono<Professor>> update(@RequestBody Professor professor, @PathVariable String id){
		Mono<Professor> professorDB = _professorService.getById(id)
				.flatMap(prof -> {
					prof.setFirstName(professor.getFirstName());
					prof.setLastName(professor.getLastName());
					prof.setGender(professor.getGender());
					prof.setBirthdayDate(professor.getBirthdayDate());
					prof.setDocType(professor.getDocType());
					prof.setDocNumber(professor.getDocNumber());
					
					return _professorService.save(prof);
				});
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(professorDB);
	}
	
	@DeleteMapping("/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteById(@PathVariable String id){
		return _professorService.deleteById(id);
	}
	
	@GetMapping("/ver/id/{id}")
	public ResponseEntity<Mono<Professor>> getById(@PathVariable String id){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_professorService.getById(id));
	}
	
	@GetMapping("/name/{firstName}")
	public ResponseEntity<Flux<Professor>> getByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_professorService.getByFirstName(firstName));
	}
	
	@GetMapping("/date/{birthdayDate}")
	public ResponseEntity<Flux<Professor>> getByBirthdayDate(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate birthdayDate){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_professorService.getByBirthdayDate(birthdayDate));
	}
	
	
	
}









