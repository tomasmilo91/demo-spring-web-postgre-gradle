package com.example.demospringweb.service.impl;

import com.example.demospringweb.domain.Person;
import com.example.demospringweb.repository.PersonRepository;
import com.example.demospringweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

}
