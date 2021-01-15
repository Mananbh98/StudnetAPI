package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    //We want to have a bean
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student manan = new Student(
                    "Manan",
                    "manan.bhanu@gamil.com",
                    LocalDate.of(2000, Month.MAY, 5),
                    21);

            Student gopi = new Student(
                    "Gopi",
                    "gopi.bhanu@gamil.com",
                    LocalDate.of(2001, Month.MAY, 5),
                    20);
            repository.saveAll(
                    List.of(manan, gopi)
            );
        };

    }
}

