package com.example.demo.student;
import com.example.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student") //
public class StudentController {

    // Reference to StudentService
    private final StudentService studentService;

    // Passing it inside the controller
    // This won't work because we dont have an instance of student service
    //So we can add new to initialize the service this.studentService = new studentService;
    // But this is not a good practice
    //So use dependency injection
    //To use it add @Autowired annotation to the constructor and @constructor to the StudentService class
    //@controller will convert the class into a spring bean and this class will be instantiated
    //@Controller and @Service are the same,but it is more relevant.So insted of Controller we will write service
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        //return the method from StudentService class
        return studentService.getStudents();

    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public  void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }



    /*
    *
    * json post request for postman {
    "name":"darknorth",
    "email":"darknorth@gamil.com",
    "dob":"2001-05-04"
    * put request
    * http://localhost:8080/api/v1/student/1?name=darknorth&email=darknorth@gmail.com
}*/

}
