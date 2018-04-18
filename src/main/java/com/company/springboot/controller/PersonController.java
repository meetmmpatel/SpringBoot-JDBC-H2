package com.company.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot.model.Person;
import com.company.springboot.repository.PersonRespository;

@RestController
public class PersonController {

	@Autowired
	PersonRespository repo;

	@RequestMapping(method = RequestMethod.GET, value = "/persons")
	public List<Person> getAll() {
		return repo.findAll();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/persons/{id}")
	public Person getOne(@PathVariable int id) {
		return repo.fineOne(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/persons")
	public Object addOne(@RequestBody Person person) {
		return repo.addOne(person);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/persons/{id}")
	public int deleteOne(@RequestBody Person person, @PathVariable int id) {
		return repo.UpdateOne(person);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/persons/{id}")
	public int deleteOne(@PathVariable int id) {
		return repo.deleteOne(id);
	}

}
