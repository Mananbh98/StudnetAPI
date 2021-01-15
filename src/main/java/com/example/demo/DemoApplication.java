package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping
	public List<Student> hello(){
		return List.of(
				new Student(
						1L,
						"Manan",
						"manan.bhanu@gamil.com",
						LocalDate.of(2000, Month.MAY, 5),
						21
				),
		new Student(
				2L,
				"Gopi",
				"gopi.bhanu@gamil.com",
				LocalDate.of(2001, Month.MAY, 5),
				20 )
		);
	}

}
