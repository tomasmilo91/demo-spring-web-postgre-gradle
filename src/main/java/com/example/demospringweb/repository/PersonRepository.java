package com.example.demospringweb.repository;

import com.example.demospringweb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findBySalaryLessThan(int salary);
}
