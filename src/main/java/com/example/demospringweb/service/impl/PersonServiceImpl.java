package com.example.demospringweb.service.impl;

import com.example.demospringweb.domain.Person;
import com.example.demospringweb.domain.PersonType;
import com.example.demospringweb.repository.PersonRepository;
import com.example.demospringweb.rest.PersonControllerImpl;
import com.example.demospringweb.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;

    public PersonServiceImpl(
            @Autowired PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons() {
        LOG.info("Getting all user data");
        return personRepository.findAll();
    }


    public List<Person> create(@Valid @RequestBody Person person) {
        personRepository.save(person);
        LOG.info("Created user data");
        return personRepository.findAll();
    }

    public List<Person> delete(@PathVariable long id) {
        personRepository.deleteById(id);
        LOG.info("Delete user data");
        return personRepository.findAll();
    }

    public List<Person> edit(@PathVariable long id, @RequestBody Person personP) {
        Optional<Person> foundedP = personRepository.findById(id);

        if (foundedP.isPresent()) {
            foundedP.get().setName(personP.getName());
            foundedP.get().setAge(personP.getAge());
            foundedP.get().setTelephone(personP.getTelephone());
            foundedP.get().setEmail(personP.getEmail());

            if (personP.getSalary() == 0) {
                foundedP.get().setPersonType(PersonType.KAN);
            } else {
                foundedP.get().setPersonType(PersonType.EMP);
                foundedP.get().setSalary(personP.getSalary());
            }
        }
        LOG.info("Edit user data");
        personRepository.saveAll(personRepository.findAll());
        return personRepository.findAll();
    }

    public List<Person> getUnderSalary(@PathVariable int salary) {
        return personRepository.findBySalaryLessThan(salary);
    }

    public Optional<Person> getEmployeeById(@PathVariable("id") long id) {
        return personRepository.findById(id);
    }


}
