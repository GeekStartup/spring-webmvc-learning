package com.geekstartup.database.database.demo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geekstartup.database.database.demo.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{

}
