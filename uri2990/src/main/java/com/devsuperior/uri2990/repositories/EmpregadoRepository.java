package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2990.entities.Empregado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

  @Query(nativeQuery = true, value = "" +
    "SELECT e.cpf , e.enome, d.dnome " +
    "FROM empregados e  " +
    "JOIN departamentos d ON e.dnumero = d.dnumero  " +
    "WHERE e.cpf  NOT IN ( " +
    "    SELECT e2.cpf " +
    "    FROM empregados e2  " +
    "    JOIN trabalha t2 ON t2.cpf_emp = e.cpf " +
    ") " +
    "ORDER BY e.cpf ")
  List<EmpregadoDeptProjection> search1();

  @Query(value = "SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptDTO(obj.cpf, obj.enome, obj.departamento.dnome) " +
    "FROM Empregado obj  " +
    "WHERE obj.cpf  NOT IN ( " +
    "    SELECT obj.cpf " +
    "    FROM Empregado obj  " +
    "    JOIN obj.projetosOndeTrabalha" +
      ") " +
    "ORDER BY obj.cpf ")
  List<EmpregadoDeptDTO> search2();

  @Query(nativeQuery = true, value = "SELECT e.cpf , e.enome, d.dnome " +
    "FROM empregados e  " +
    "JOIN departamentos d ON e.dnumero = d.dnumero " +
    "LEFT JOIN trabalha t ON t.cpf_emp = e.cpf   " +
    "WHERE t.cpf_emp IS NULL  " +
    "ORDER BY e.cpf ")
  List<EmpregadoDeptProjection> search3();


}
