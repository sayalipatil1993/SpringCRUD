package com.sayali.spring.boot.crud.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sayali.spring.boot.crud.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
