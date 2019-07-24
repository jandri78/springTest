package com.telintel.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telintel.demo.model.Person;
import com.telintel.demo.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonsController {
  @Autowired
  private PersonRepository repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Person> getAllpersons() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Person getpersonById(@PathVariable("id") ObjectId id) {
    return repository.findBy_id(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifypersonById(@PathVariable("id") ObjectId id, @Valid @RequestBody Person persons) {
    persons.set_id(id);
    repository.save(persons);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Person createperson(@Valid @RequestBody Person persons) {
	  String name = persons.getName();
	  
	  List<Person> p = repository.findByThePersonsFirstname(name);
	  for (Person person : p) {
		String nombre = person.getName();
		if (nombre.equals(name)) {
			return null;
		}
	}
		 persons.set_id(ObjectId.get());
		    repository.save(persons);
		    return persons;
	  
   
  }
  
  @RequestMapping(value = "/multi/", method = RequestMethod.POST)
  public HttpStatus createPersontMulti(@Valid @RequestBody List<Person> persons) {

	  if (persons.isEmpty()) {
		  
		    return HttpStatus.CONFLICT;
	}else {
		repository.insert(persons);
		return HttpStatus.ACCEPTED;
	}

  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePerson(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
  
  @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
  public List<Person> getByName(@PathVariable("name")String name) {
	  return repository.findByThePersonsFirstname(name);
  }
  
  
  @RequestMapping(value = "/name/", method = RequestMethod.GET)
  public List<Person> getByNameAll() {
	 
    return repository.findAll();
  }
}
