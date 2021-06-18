package io.github.sejoung.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.sejoung.jpa.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
