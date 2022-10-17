package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.data.Student;
import com.geekbrains.spring.web.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student findById(Long id) {
       return studentRepository.findById(id).orElseThrow();
    }

    public List<Student> findByScore(Integer min, Integer max) {
        return studentRepository.findAllByScoreBetween(min, max);
    }

    @Transactional
    public void changeScore(Long studentId, Integer delta) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setScore(student.getScore() + delta);
        //studentRepository.save(student);
    }
}
