package com.example.demospringweb.dao.impl;

import com.example.demospringweb.dao.PersonDao;
import com.example.demospringweb.domain.Person;
import com.example.demospringweb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public List<Person> getAllPersons() {
        return this.personRepository.findAll();
    }


    @Override
    public Boolean addPerson(Person person) {
        this.personRepository.save(person);
        return true;
    }

    @Override
    public Boolean deletePerson(Long foodId) {
        if (this.personRepository.existsById(foodId)) {
            this.personRepository.deleteById(foodId);
            return true;
        }
        else {
            return false;
        }
    }


}
