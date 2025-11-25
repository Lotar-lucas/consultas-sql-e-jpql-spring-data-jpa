package com.devsuperior.uri2990;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.repositories.EmpregadoRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    System.out.println("-----------------RESULTADO SQL NOT IN -------------- ");
    List<EmpregadoDeptProjection> list1 = repository.search1();
    List<EmpregadoDeptDTO> response1 = list1.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());

    for (EmpregadoDeptDTO obj : response1) {
      System.out.println(obj);
    }

    System.out.println("\n\n");


    System.out.println("--------------------------RESULTADO JPQL--------------------- ");
    List<EmpregadoDeptDTO> response2 = repository.search2();

    for (EmpregadoDeptDTO obj : response1) {
      System.out.println(obj);
    }
    System.out.println("\n\n");


    System.out.println("-----------------RESULTADO SQL LEFT JOIN -------------- ");
    List<EmpregadoDeptProjection> list3 = repository.search3();
    List<EmpregadoDeptDTO> response3 = list1.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());

    for (EmpregadoDeptDTO obj : response3) {
      System.out.println(obj);
    }

    System.out.println("\n\n");

	}
}
