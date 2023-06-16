package com.cursospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.model.Person;
import com.cursospring.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> getAll() {
		return personRepository.findAll();	
	}
	
	public Person getById(Long id) {
		return personRepository.findById(id).get();
	}
	
	public void delete(Person person) {
		personRepository.delete(person);
	}
	
	public Person update(Long id, Person person) {
		Person obj = personRepository.findById(id).get();
		updateData(obj, person);
		return personRepository.save(obj);
	}
	
	private void updateData(Person obj, Person person) {
		obj.setFirstName(person.getFirstName());
		obj.setLastName(person.getLastName());
		obj.setAddress(person.getAddress());
		obj.setGender(person.getGender());
	}

}
