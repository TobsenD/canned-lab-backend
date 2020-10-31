package de.dols.cannedlabbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.dols.cannedlabbackend.model.Product;
import de.dols.cannedlabbackend.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	private final ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@PostMapping("/products")
	void addUser(@RequestBody Product product) {
		productRepository.save(product);
	}

}
