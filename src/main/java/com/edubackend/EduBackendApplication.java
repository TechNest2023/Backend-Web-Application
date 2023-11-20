package com.edubackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EduBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduBackendApplication.class, args);
	}

}
