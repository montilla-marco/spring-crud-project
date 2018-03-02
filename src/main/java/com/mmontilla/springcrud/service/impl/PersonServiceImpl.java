package com.mmontilla.springcrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmontilla.springcrud.domain.Person;
import com.mmontilla.springcrud.jpa.PersonRepository;
import com.mmontilla.springcrud.service.PersonService;

/**
 * Service tier, make a wrap around  PersonRepository, it is 
 * a logical separation between HTTP and JPA tiers.
 * @author marcomarco++
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	/**
	 * JPA repo.
	 */
	@Autowired
	private PersonRepository repo;


	@Override
	public List<Person> findAll() {
		return repo.findAll();
	}

	@Override
	public Person findOne(Long id) {
		return repo.findOne(id);
	}

	@Override
	public void delete(Person person) {
		repo.delete(person);
	}

	@Override
	public Person save(Person person) {
		return repo.save(person);
	}
	
	
}
