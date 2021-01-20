package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//This allows us to initialize the class to be used in another class

@Service  //This class is ment to be service class looking at the name
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return  studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
    studentRepository.findById(studentId);
    boolean exists = studentRepository.existsById(studentId);
    if(!exists){
        throw new IllegalStateException(
                "student with id"+ studentId + "deos not exits");
    }
    studentRepository.deleteById(studentId);
    // check delete in postman on url http://localhost:8080/api/v1/student/1
    }

    //As we used psql query to find email for post method we arent using any for here
    // @Transcational annotation  does is that the entity goes into a manage state
    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id "+ studentId + "does not exist"
                )
                );
                if(name != null &&
                name.length()>0 &&
                !Objects.equals(student.getName(),name)){
                    student.setName(name);
                }
                if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(),email)){
                    Optional<Student> studentOptional = studentRepository
                            .findStudentByEmail(email);
                    if(studentOptional.isPresent()){
                        throw new IllegalStateException("email taken");
                    }
                    student.setEmail(email);
                }
    }
}



/* Static data
* List.of(
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
    }*/