package com.example.demo.student;
import com.example.demo.student.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student") //
public class StudentController {

    // Reference to StudentService
    private final StudentService studentService;

    // Adding the constructor
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        //return the method from StudentService class
        return studentService.getStudents();

    }


}
