package com.sayali.spring.boot.crud.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sayali.spring.boot.crud.app.entity.Product;
import com.sayali.spring.boot.crud.app.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository repo;

	public List<Product> findAllList() {
		return repo.findAll();
	}

	public Product save(Product p) {
		return repo.save(p);
	}

	public Product update(Product p) {
		return repo.save(p);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public Optional<Product> getProduct(Long id) {
		return repo.findById(id);
	}
}
