package com.example.demospringweb.service;

import com.example.demospringweb.domain.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    public List<Person> getAllPersons();

    public List<Person> create(@Valid @RequestBody Person person);

    public List<Person> delete(@PathVariable long id);

    public List<Person> edit(@PathVariable long id, @RequestBody Person personP);

    public List<Person> getUnderSalary(@PathVariable int salary);

    public Optional<Person> getEmployeeById(@PathVariable("id") long id);
}
