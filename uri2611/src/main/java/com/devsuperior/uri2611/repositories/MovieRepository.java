package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

  //Consulta SQL
  @Query(nativeQuery = true, value = "SELECT m.id, m.\"name\""
    + "FROM movies as m "
    + "JOIN genres as g ON g.id = m.id_genres "
    + "WHERE UPPER(g.description) = UPPER(:genreName)")
  List<MovieMinProjection> search1(String genreName);

  //Consulta JPQL
  @Query(value = "SELECT new com.devsuperior.uri2611.dto.MovieMinDTO(obj.id, obj.name) "
    + "FROM Movie obj "
    + "WHERE obj.genre.description = :genreName")
  List<MovieMinDTO> search2(String genreName);

  //para buscar em um relacionamento para 1 podemos navegar pelo atributo , que neste caso é genre.
}
