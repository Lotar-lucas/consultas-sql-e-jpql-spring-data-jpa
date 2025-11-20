package com.devsuperior.uri2609;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.repositories.CategoryRepository;

import java.util.List;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

    List<CategorySumProjection> list = repository.search1();
    List<CategorySumDTO> listDTO = list.stream().map(CategorySumDTO::new).toList();

    System.out.println("RESULTADO SQL");
    for (CategorySumDTO dto : listDTO) {
      System.out.println(dto);
    }

    System.out.println("\n\n");

    List<CategorySumDTO> list2 = repository.search2();
    System.out.println("RESULTADO JPQL");
    for (CategorySumDTO dto : list2) {
      System.out.println(dto);
    }

	}
}
