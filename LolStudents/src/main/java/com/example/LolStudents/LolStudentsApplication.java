package com.example.LolStudents;

import com.example.LolStudents.entity.Student;

import com.example.LolStudents.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LolStudentsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LolStudentsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {



	}


}
