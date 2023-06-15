package com.cursospring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(personService.getById(id));
		
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Person person){
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Person person){
		return ResponseEntity.status(HttpStatus.OK).body(personService.save(person));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id, @RequestBody Person person){
		person = personService.getById(person.getId());
		if(person == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		personService.delete(person);				
		return ResponseEntity.status(HttpStatus.OK).body("deleted!");
	}
}
