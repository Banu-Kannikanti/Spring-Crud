package com.javatechie.Springbootcurdexample.repository;
import com.javatechie.Springbootcurdexample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	    Product findByName(String name);
	}

