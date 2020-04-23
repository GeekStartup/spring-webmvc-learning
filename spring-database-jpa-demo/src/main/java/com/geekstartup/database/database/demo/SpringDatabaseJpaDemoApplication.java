package com.geekstartup.database.database.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geekstartup.database.database.demo.entity.Person;
import com.geekstartup.database.database.demo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDatabaseJpaDemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	 * 
	 @Autowired
	 private PersonJdbcDao dao;
	 

	@Autowired
	private PersonJpaRepository repository;
	*/
	
	@Autowired
	private PersonSpringDataRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("User id 10001 -> {}", repository.findById(10001));
		
		Person person = repository.save(new Person("Ashish", "Mexico City", new Date()));
		logger.info("Insert id {} -> {}",person.getId() ,person);
		
		logger.info("Update 10003 -> {}",
				repository.save(new Person(10003, "Sarmista", "Guadalajara", new Date())));
		
		logger.info("Delete id 10002"); 
		repository.deleteById(10002);
		
		logger.info("All users -> {}", repository.findAll());	
		
		/*
		logger.info("User id 10001 -> {}", repository.findById(10001));
		
		Person person = repository.insert(new Person("Ashish", "Mexico City", new Date()));
		logger.info("Insert id {} -> {}",person.getId() ,person);
		
		logger.info("Update 10003 -> {}",
				repository.update(new Person(10003, "Sarmista", "Guadalajara", new Date())));
		
		logger.info("Delete id 10002"); 
		repository.deleteById(10002);
		
		logger.info("All users -> {}", repository.findAll());	
		*/
		
		/*
		logger.info("All users -> {}", dao.findAll());		 
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("Delete id 10002 -> No. of rows deleted - {}", dao.deleteById(10002));
		logger.info("Insert id 10004 -> No. of rows inserted - {}", 
				dao.insert(new Person(10004, "Ashish", "Mexico City", new Date())));
		logger.info("Update 10003 -> No. of rows updated - {}",
				dao.update(new Person(10003, "Sarmista", "Guadalajara", new Date())));
		
		*/
	}

}
