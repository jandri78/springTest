package com.telintel.demo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.telintel.demo.model.Person;

public interface PersonRepository extends MongoRepository<Person, String>{
	Person findBy_id(ObjectId _id);
	
	 @Query("{ 'Name' : ?0 }")
	  List<Person> findByThePersonsFirstname(String firstname);
	 
}
