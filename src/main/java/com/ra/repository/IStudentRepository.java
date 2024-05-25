package com.ra.repository;

import com.ra.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
    Student findById(int id);
    void remove(int id);
    List<Student> findByName(String name);
}
