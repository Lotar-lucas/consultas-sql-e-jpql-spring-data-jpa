package com.devsuperior.uri2737.repositories;

import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2737.entities.Lawyer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

  @Query(nativeQuery = true, value ="( SELECT l.\"name\", l.customers_number as  customersNumber "
    +"FROM lawyers l  "
    +"WHERE customers_number = ( "
        +"SELECT max(l.customers_number) "
        +"FROM lawyers l ) )"
    +" UNION ALL "
    +"( SELECT l.\"name\", l.customers_number   "
    +"  FROM lawyers l  "
    +"  WHERE customers_number = ( "
        +"SELECT min(l.customers_number) "
        +" FROM lawyers l )) "
    +"UNION ALL  "
    +"( SELECT 'Average' AS name , "
    +"  round(avg(l.customers_number)) AS customers_number "
    +"FROM lawyers l )"
  )
  List<LawyerMinProjection> search1();


  //JPQL não tem union, dependendo do caso vale mais a pena usar SQL quando a solução precisa de union}

}
