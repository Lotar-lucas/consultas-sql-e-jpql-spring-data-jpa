package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query(nativeQuery = true, value = "SELECT p.name "
    + "FROM products p  "
    + "JOIN providers p2 ON p.id_providers = p2.id "
    + "WHERE p.amount BETWEEN :min AND :max "
    + "AND p2.name ilike CONCAT(:beginName, '%')")
  List<ProductMinProjection> search1(Integer min, Integer max, String beginName);

}
