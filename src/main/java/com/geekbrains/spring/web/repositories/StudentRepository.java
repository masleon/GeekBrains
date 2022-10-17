package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.data.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByScoreBetween(Integer min, Integer max);

    @Query("select s from Student s where s.score < 80")
    List<Student> findLowRatingStudents();

    @Query("select s from Student s where s.name = :name")
    Optional<Student> findStudentByName(String name);

    // Если бы у студентов был List<Book>, то не ленивая загрузка книг:
    // @Query("select s from Student s join fetch s.books where s.id = :id")
    // Optional<Student> findByIdWithBooks(String name);



}
