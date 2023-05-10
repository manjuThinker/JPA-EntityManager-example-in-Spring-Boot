package com.entityManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entityManager.model.Tutorial;
import com.entityManager.repository.TutorialRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	TutorialRepository tutorialRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		tutorialRepository.deleteAll();
		tutorialRepository.save(new Tutorial("Java Spring", "Tut#2 Description", false));
		tutorialRepository.save(new Tutorial("Hibernate", "Tut#3 Description", false));
		tutorialRepository.save(new Tutorial("Spring Boot", "Tut#4 Description", false));
		tutorialRepository.save(new Tutorial("Spring Data JPA", "Tut#5 Description", false));
		tutorialRepository.save(new Tutorial("JPA EntityManager", "Tut#6 Description", false));
		tutorialRepository.save(new Tutorial("Spring Security", "Tut#7 Description", false));

		List<Tutorial> tutorials = new ArrayList<>();

		tutorials = tutorialRepository.findAll();
		show(tutorials);

	}

	private void show(List<Tutorial> tutorials) {

		for (Iterator iterator = tutorials.iterator(); iterator.hasNext();) {
			Tutorial tutorial = (Tutorial) iterator.next();
			
			System.out.println(tutorial);

		}

	}

}
