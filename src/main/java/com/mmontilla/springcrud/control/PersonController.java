package com.mmontilla.springcrud.control;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RestController;


import com.mmontilla.springcrud.service.PersonService;
import com.mmontilla.springcrud.domain.Person;
/**
 * 
 * @author Marco A. Montilla R. marcomarco++
 *
 */
@RestController
public class PersonController {

	/**
	 * Wrapper service.
	 */
	@Autowired
	private PersonService service;
	
	/**
	 * Method to get all Persons in BD.
	 * @param model containing all objects.
	 * @return JSON.
	 */
	@GetMapping("/person")
	public List<Person> getAll() {
		return service.findAll();
	}

	// Get a Single Person
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long noteId) {
		Person person = service.findOne(noteId);
	    if(person == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(person);
	}
	
	/**
	 * Create a Single Person
	 * @param person
	 * @return
	 */
	@PostMapping("/person")
	public Person createNote(@Valid @RequestBody Person person) {
	    return service.save(person);
	}
	
	/**
	 * Delete a Person.
	 * @param personId
	 * @return
	 */
	@DeleteMapping("/person/{id}")
	public ResponseEntity<Person> deleteNote(@PathVariable(value = "id") Long noteId) {
		Person person = service.findOne(noteId);
	    if(person == null) {
	        return ResponseEntity.notFound().build();
	    }
	    service.delete(person);
	    return ResponseEntity.ok().build();
	}
	
	/**
	 * Updates a Person.
	 * @param personId
	 * @param personDetails
	 * @return
	 */
	@PutMapping("/person/{id}")
	public ResponseEntity<Person> updateNote(@PathVariable(value = "id") Long noteId, 
	                                         @Valid @RequestBody Person personDetails) {
		Person person = service.findOne(noteId);
	    if(person == null) {
	        return ResponseEntity.notFound().build();
	    }
	    person.setFirstName(personDetails.getFirstName());
	    person.setLastName(personDetails.getLastName());

	    Person updatedPerson = service.save(person);
	    return ResponseEntity.ok(updatedPerson);
	}
	
	
}
