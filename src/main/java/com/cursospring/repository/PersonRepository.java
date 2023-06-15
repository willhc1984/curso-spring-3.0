package com.cursospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
