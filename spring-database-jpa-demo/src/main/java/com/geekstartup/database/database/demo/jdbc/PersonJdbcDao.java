package com.geekstartup.database.database.demo.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.geekstartup.database.database.demo.entity.Person;



@Repository
public class PersonJdbcDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
		
	}
	
	public Person findById(int id){
		return jdbcTemplate.queryForObject("select * from person where id=?",new Object[] {id} , 
				new PersonRowMapper());
		
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("insert into person(id,name,location,birth_date) "+ "values(?,?,?,?)", 
				new Object[] {person.getId(),
						person.getName(),
						person.getLocation(),
						new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person) {
		return jdbcTemplate.update("update person " + "set name=?, location=?, birth_date=? "+ "where id=?", 
				new Object[] {person.getName(),
						person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()),
						person.getId()});
	}
	
}
