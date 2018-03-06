package com.mmontilla.springcrud.control.unit.control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.ArrayList;

import com.mmontilla.springcrud.domain.Person;
import com.mmontilla.springcrud.control.PersonController;
import com.mmontilla.springcrud.service.PersonService;
import com.mmontilla.springcrud.service.impl.PersonServiceImpl;

import org.springframework.test.util.ReflectionTestUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing the  Person Controller!!!")
public class PersonControllerTest {

	private static final Logger log = LoggerFactory.getLogger(PersonControllerTest.class);

	private final List<Person> persons = new ArrayList<>();

	@BeforeEach
	public void setUp() throws Exception {
		log.info("@BeforeEach: setUp()");
		Person person = new Person();
		person.setId(1l);
		person.setFirstName("John");
		person.setLastName("Mayer");
		persons.add(person);
	}

	@AfterEach
	public void tearDown() throws Exception {
		log.info("@AfterEach: tearDown()");
		
		log.trace("Hello World!");
		log.debug("How are you today?");
		log.info("I am fine.");
		log.warn("I love programming.");
		log.error("I am programming.");
	}

	@Test
	@DisplayName("This test get all Person objects via GET method")
	public void testList() throws Exception {

		PersonService personService = mock(PersonServiceImpl.class);
		when(personService.findAll()).thenReturn(persons);

		PersonController controller = new PersonController();
		ReflectionTestUtils.setField(controller, "service", personService);

		assertEquals(1, controller.getAll().size());
		assertEquals(persons, controller.getAll());

		
	}
}
