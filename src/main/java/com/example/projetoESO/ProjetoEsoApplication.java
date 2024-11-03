package com.example.projetoESO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjetoEsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoEsoApplication.class, args);
	}

}
