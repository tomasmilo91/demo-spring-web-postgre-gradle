package com.example.demospringweb.rest;


import com.example.demospringweb.domain.Person;
import com.example.demospringweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/persons")
public class PersonControllerImpl {

    private final PersonService personService;

    public PersonControllerImpl(
            @Autowired PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/all")
    public List<Person> getAll() {
        return personService.getAllPersons();
    }



    @PostMapping(value = "/create")
    public List<Person> create(@Valid @RequestBody Person person) {
        return personService.create(person);
    }

    @DeleteMapping(value = "/delete/{id}")
    public List<Person> delete(@PathVariable long id) {
        return personService.delete(id);
    }

    @PutMapping(value = "/edit/{id}")
    public List<Person> edit(@PathVariable long id, @RequestBody Person personP) {
        return personService.edit(id, personP);
    }

    @GetMapping("/underaveragesalary/{salary}")
    public List<Person> getUnderSalary(@PathVariable int salary) {
        return personService.getUnderSalary(salary);
    }

    @GetMapping("/employees/{id}")
    public Optional<Person> getEmployeeById(@PathVariable("id") long id) {
        return personService.getEmployeeById(id);
    }

}
