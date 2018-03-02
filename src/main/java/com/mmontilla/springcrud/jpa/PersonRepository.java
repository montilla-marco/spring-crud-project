package com.mmontilla.springcrud.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmontilla.springcrud.domain.Person;

/**
 * Database connection glue.
 * 
 * @author Marco A. Montilla R. marcomarco++
 */
public interface PersonRepository extends JpaRepository<Person, Long> { }

