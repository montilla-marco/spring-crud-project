package com.mmontilla.springcrud.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mmontilla.springcrud.domain.Person;
import com.mmontilla.springcrud.jpa.PersonRepository;
/**
 * The main class.
 * @author Marco A. Montilla R. marcomarco++
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.mmontilla.springcrud.config",
							   "com.mmontilla.springcrud.control",
							   "com.mmontilla.springcrud.service",
							   "com.mmontilla.springcrud.service.impl"})
public class SpringCrudApplication {

	@Bean 
	InitializingBean saveData(PersonRepository repo){ 
		return () -> { 
		repo.save(new Person("Marco", "Montilla")); 
		repo.save(new Person("Antonio","Rodriguez")); 
		repo.save(new Person("Dalvito", "Dominguez")); 
		repo.save(new Person("Ely", "Reina")); 
		}; 
	}
	
	/**
	 * Main spring application start method.
	 * @param args from CLI. 
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}
}
