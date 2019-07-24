package com.telintel.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/Test")
public class Test {

	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public String getAllPets() {
	    return "HI";
	  }
}
