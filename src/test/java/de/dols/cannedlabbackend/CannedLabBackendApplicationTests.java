package de.dols.cannedlabbackend;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import de.dols.cannedlabbackend.model.Product;
import de.dols.cannedlabbackend.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-dev.properties")
class CannedLabBackendApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@BeforeEach
	public void setUp() throws Exception {
		Stream.of("Erbsen", "Möhren", "Nudeln", "Steak").forEach(name -> {
			Product product = new Product(name, "EINGEKOCHT", new Date(), 2);
			productRepository.save(product);
		});
	}

	@Test
	void contextLoads() {
		Product productA = productRepository.findById((long) 1).get();
		assertNotNull(productA);
		assertEquals("Erbsen", productA.getName());

		int count = 0;

		Iterable<Product> products = productRepository.findAll();
		for (Product p : products) {
			count++;
		}
		assertEquals(count, 4);
	}

}
