package com.example.demospringweb.dao;

import com.example.demospringweb.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao {

    public List<Person> getAllPersons();
    public Boolean addPerson(Person person);
    public Boolean deletePerson(Long foodId);
}
