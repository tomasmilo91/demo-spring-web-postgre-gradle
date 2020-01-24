package com.example.demospringweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class DemoSpringWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoSpringWebApplication.class, args);
	}

}
