package de.dols.cannedlabbackend;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.dols.cannedlabbackend.model.Product;
import de.dols.cannedlabbackend.repository.ProductRepository;

@EnableJpaRepositories
@SpringBootApplication
public class CannedLabBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CannedLabBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository productRepository) {
		return args -> {
			Stream.of("Erbsen", "Möhren", "Nudeln", "Steak").forEach(name -> {
				Product product = new Product(name, "EINGEKOCHT", new Date(), 2);
				productRepository.save(product);
			});
			productRepository.findAll().forEach(System.out::println);
		};
	}

}
