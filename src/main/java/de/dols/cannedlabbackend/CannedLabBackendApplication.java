package de.dols.cannedlabbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class CannedLabBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CannedLabBackendApplication.class, args);
	}

}
