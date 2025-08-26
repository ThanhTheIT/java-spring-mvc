package com.theer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theer.domain.Product;
import com.theer.repository.ProductRepository;;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
