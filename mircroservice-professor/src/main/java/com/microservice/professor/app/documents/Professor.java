package com.microservice.professor.app.documents;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Document(collection = "professor")
public class Professor implements Serializable{

	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate birthdayDate;

	private String docType;
	private String docNumber;
	
	
	
	private static final long serialVersionUID = -5176885039181659571L;
	
	
}
