package com.example.demo.student;



import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Student {
    //Defining our Model's(Student) attribute and behaviour
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private String email ;
    private LocalDate dob;

    private Integer age;

    // 3 Constructors in total
    // 1. No R constructor(empty)
    public Student()
        {
        }

    // 2. constructor with every attribute


    public Student(long id,
                   String name,
                   String email,
                   LocalDate dob,
                   Integer age)
        {
            this.id = id;
            this.name = name;
            this.dob = dob;
            this.email = email;
            this.age = age;
        }


    // 3. Constructor without id as db will be creating that for us


    public Student(String name,
                   String email,
                   LocalDate dob,
                   Integer age)
    {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.age = age;
    }

    //Getter and setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //ToString


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
