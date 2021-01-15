package com.example.demo.student;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//This allows us to initialize the class to be used in another class

@Service  //This class is ment to be service class looking at the name
public class StudentService {

    public List<Student> getStudents(){
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
