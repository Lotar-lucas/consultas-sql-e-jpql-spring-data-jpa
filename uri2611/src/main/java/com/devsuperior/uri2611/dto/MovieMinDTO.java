package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projections.MovieMinProjection;

public class MovieMinDTO {
  private Long id;
  private String genreName;

  public MovieMinDTO() {}

  public MovieMinDTO(Long id, String genreName) {
    this.id = id;
    this.genreName = genreName;
  }

  public MovieMinDTO(MovieMinProjection projection) {
    id = projection.getId();
    genreName = projection.getName();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGenreName() {
    return genreName;
  }

  public void setGenreName(String genreName) {
    this.genreName = genreName;
  }

  @Override
  public String toString() {
    return "MovieMinDTO{" + "id=" + id + ", genreName='" + genreName + '\'' + '}';
  }
}
