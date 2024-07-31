package com.gestor.gestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.gestor")
@EntityScan("com.gestor.entity")
@ComponentScan(basePackages = { "com.gestor.*" })
public class Gestor {

	public static void main(String[] args) {
		SpringApplication.run(Gestor.class, args);
	}

}
