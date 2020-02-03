package com.example.demospringweb.domain;

import javax.persistence.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_generator")
    @SequenceGenerator(name="person_id_generator", sequenceName="person_id_seq",allocationSize=1)

    private long id;

    @NotNull
    @Valid
    @Size(min=3, message="Name should have atleast 3 characters")
    private String name;

    private Integer age;
    private String telephone;
    private String email;
    private int salary;

    @Enumerated
    private PersonType personType;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public Person(String name, Integer age, String telephone, String email) {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.personType=PersonType.KAN;
    }

    public Person(String name, Integer age, String telephone, String email, int salary) {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.salary=salary;
        this.personType=PersonType.EMP;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            if (id == p.getId() && name.equals(p.getName()) && age == p.getAge() && telephone.equals(p.getTelephone()) && email.equals(p.getEmail()))
                return true;
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }


}
