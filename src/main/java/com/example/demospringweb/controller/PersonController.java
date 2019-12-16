package com.example.demospringweb.controller;

import com.example.demospringweb.model.Person;
import com.example.demospringweb.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController  //return list of objects
@RequestMapping(value = "/persons")
public class PersonController {

    PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Person> getAll(){
        return personRepository.findAll();

    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public List<Person> create(@RequestBody Person person){
        personRepository.save(person);
        return personRepository.findAll();

    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public List<Person> delete(@PathVariable long id){
        personRepository.deleteById(id);
        return personRepository.findAll();
    }
}
