package de.dols.cannedlabbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.dols.cannedlabbackend.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
