package com.cursospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospring.dto.PersonDTO;
import com.cursospring.mapper.DozerMapper;
import com.cursospring.model.Person;
import com.cursospring.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<PersonDTO> getAll() {
		return DozerMapper.parseListObjects(personRepository.findAll(), PersonDTO.class);	
	}
	
	public PersonDTO getById(Long id) {
		return DozerMapper.parseObject(personRepository.findById(id).get(), PersonDTO.class);
	}
	
	public PersonDTO save(PersonDTO person) {
		var entity = DozerMapper.parseObject(person, Person.class);
		var dto = DozerMapper.parseObject(personRepository.save(entity), PersonDTO.class);
		return dto;
	}
	
	public void delete(Long id) {
		var entity = personRepository.findById(id).get();
		personRepository.delete(entity);
	}
	
	public PersonDTO update(PersonDTO person) {
		Person entity = personRepository.findById(person.getId()).get();
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var dto = DozerMapper.parseObject(personRepository.save(entity), PersonDTO.class);
		return dto;
	}

}
