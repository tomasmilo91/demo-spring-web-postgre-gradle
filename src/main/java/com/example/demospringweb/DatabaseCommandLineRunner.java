package com.example.demospringweb;

import com.example.demospringweb.repository.PersonRepository;
import com.example.demospringweb.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/*
Command Line Runner is an interface. It is used to execute the code after the Spring Boot application started.
 The example given below shows how to implement the Command Line Runner interface on the main class file.
*/
@Component
public class DatabaseCommandLineRunner implements CommandLineRunner {
    private PersonRepository personRepository;


    @Autowired
    public DatabaseCommandLineRunner(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
/*
        List<Person> persons= new ArrayList<>();


        persons.add(new Person("Kandidate First",39, "0904567888","emailfirst@email.cz"));
        persons.add(new Person("Employee First",39, "0904567888","emailemployeefirst@email.cz", 3000));
        persons.add(new Person("Kandidate Second",31, "0907767888","emailsecond@email.cz"));
        persons.add(new Person("Employee First",39, "0909867888","emailemployeesecond@email.cz", 1600));


        personRepository.saveAll(persons);
*/

    }
}
