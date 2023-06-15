package com.cursospring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.model.Person;
import com.cursospring.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public ResponseEntity<List<Person>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(personService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Person person){
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
	}

}
