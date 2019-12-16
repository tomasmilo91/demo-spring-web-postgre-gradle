package com.example.demospringweb.service;

import com.example.demospringweb.dao.PersonRepository;
import com.example.demospringweb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private PersonRepository personRepository;

    @Autowired
    public DatabaseSeeder (PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Person> persons= new ArrayList<>();

        persons.add(new Person("Tomas Novy",33, "0904567888","email@email.cz"));
        persons.add(new Person("Tomas Novy2",34, "0904567889","email1@email.cz"));
        //persons.add(new Person("Tomas Novy3",35, "0904567880","email2@email.cz"));

        personRepository.saveAll(persons);

    }
}
