package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.data.Student;
import com.geekbrains.spring.web.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/find/{id}")
    public Student deleteById(@PathVariable Long id) {
        return studentService.findById(id);
    }

//    @GetMapping("/students/change_score")
//    public void changeScore(@RequestParam Long studentId, @RequestParam Integer delta) {
//        studentService.changeScore(studentId, delta);
//    }

    @GetMapping("/students/between")
    public List<Student> findByScore(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "100") Integer max) {
        return studentService.findByScore(min, max);
    }
}
