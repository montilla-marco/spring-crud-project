package com.mmontilla.springcrud.service;

import java.util.List;

import com.mmontilla.springcrud.domain.Person;

public interface PersonService {

	 /**
	 * Retrieves all the Person elements.
	 * @return list of all persons in data base.
	 */
	public List<Person> findAll(); 
	
	/**
	 * Retrieves the element that match the conditions defined by
	 * the specified id
	 * @param id of person
	 * @return finded object.
	 */
	public Person findOne(Long id);

	/**
	 * Deletes a person with thes pecified id.
	 * @param person to delete.
	 */
	public void delete(Person person);

	/**
	 * Save a single person.
	 * @param person to be saved.
	 * @return object updated.
	 */
	public Person save(Person person);
	
	

}
