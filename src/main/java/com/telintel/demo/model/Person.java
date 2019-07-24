package com.telintel.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Person {
	@Id
	public ObjectId _id;

	private String Name;
	private String LastName;
	private int Age;
	private String Address;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(ObjectId _id, String name, String lastName, int age, String address) {
		super();
		this._id = _id;
		Name = name;
		LastName = lastName;
		Age = age;
		Address = address;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}
