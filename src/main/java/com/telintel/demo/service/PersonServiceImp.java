package com.telintel.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telintel.demo.model.Person;

@Service
public interface PersonServiceImp {

		 
	public List<Person>getPersons();
	
	public Person getpersonById(String personId);
}
