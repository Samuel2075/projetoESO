package com.example.projetoESO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.example.projetoESO.repositories")
public class ProjetoEsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoEsoApplication.class, args);
	}

}
