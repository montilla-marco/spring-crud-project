package com.mmontilla.springcrud.domain;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 

/**
* The following class it's for demostration purposes, it objetive is
* demostrate some of the fun of spring programming world.
*
* Marco A. Montilla R. marcomarco++
*/
@Entity
public class Person {

    /**
    * Person identificator in database.
    */
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;

	/**
	* The name of person.
	*/
	private String firstName;

	/**
	* The last of person.
	*/
	private String lastName;
	
	/**
	 * Default constructor;
	 */
	public Person() {}

	/**
	 * Fast constructor.
	 * @param firstName of peron.
	 * @param lastName of peron.
	 */
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}