package com.example.demospringweb;

import com.example.demospringweb.controller.PersonController;
import com.example.demospringweb.dao.PersonRepository;
import com.example.demospringweb.model.Person;
import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@AutoConfigureTestEntityManager
class DemoSpringWebApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PersonController controller;

	@Autowired
	private PersonRepository personRepository;

	@BeforeAll
	static void setup(){
		System.out.println("@BeforeAll executed");
	}

/*
	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
		Person abc=new Person("Kandidate First",39, "0904567888","emailfirst@email.cz");

		entityManager.persist(abc);

		String str = "Junit is working fine";
		assertEquals("Junit is working fine",str);

	}

*/



}
