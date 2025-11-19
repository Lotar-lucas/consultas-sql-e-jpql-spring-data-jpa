package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>  {

  // consulta customizada utilizando SQL nativo
  @Query(nativeQuery = true, value = "SELECT c.name FROM customers c WHERE c.state = :state")
  List<CustomerMinProjection> searchWithSQL(String state);
}
