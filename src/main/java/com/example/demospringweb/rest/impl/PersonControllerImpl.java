package com.example.demospringweb.rest.impl;


import com.example.demospringweb.domain.Person;
import com.example.demospringweb.repository.PersonRepository;
import com.example.demospringweb.domain.PersonType;
import com.example.demospringweb.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController  //return list of objects
@RequestMapping(value = "/persons")
public class PersonControllerImpl {


    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    private static final Logger LOG = LoggerFactory.getLogger(PersonControllerImpl.class);

    @Autowired
    public PersonControllerImpl(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Person> getAll(){
        LOG.info("Getall user data");
        return personRepository.findAll();
    }

    //getmapping using service
    @GetMapping(value="/all2")
    public List<Person> getAll2(){
        LOG.info("Getall user data");
        return personService.getAllPersons();
    }


    @RequestMapping(value="/create", method = RequestMethod.POST)
    public List<Person> create(@Valid @RequestBody Person person){
        personRepository.save(person);
        LOG.info("Created user data");
        return personRepository.findAll();

    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public List<Person> delete(@PathVariable long id){
        personRepository.deleteById(id);
        LOG.info("Delete user data");
        return personRepository.findAll();
    }


    @RequestMapping(value="/edit/{id}", method = RequestMethod.PUT)
    public List<Person> edit(@PathVariable long id,@RequestBody Person personP){
        Optional<Person> foundedP = personRepository.findById(id);

        if(foundedP.isPresent()){
            foundedP.get().setName(personP.getName());
            foundedP.get().setAge(personP.getAge());
            foundedP.get().setTelephone(personP.getTelephone());
            foundedP.get().setEmail(personP.getEmail());

            if(personP.getSalary()==0){
                 foundedP.get().setPersonType(PersonType.KAN);
            }
            else{
                foundedP.get().setPersonType(PersonType.EMP);
                foundedP.get().setSalary(personP.getSalary());
            }
        }
        LOG.info("Edit user data");
        personRepository.saveAll(personRepository.findAll());
        return personRepository.findAll();
    }

    @GetMapping("/underaveragesalary/{salary}")
    public List<Person> getUnderSalary(@PathVariable int salary){
        return personRepository.findBySalaryLessThan(salary);
    }

    @GetMapping("/employees/{id}")
    public Optional<Person> getEmployeeById (@PathVariable("id") long id) {
        return personRepository.findById(id);
    }

}
