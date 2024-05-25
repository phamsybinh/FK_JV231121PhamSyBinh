package com.ra.service;

import com.ra.dto.request.CreateStudentForm;
import com.ra.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(CreateStudentForm request);
    Student findById(int id);
    void remove(int id);
    List<Student> findByName(String name);
}
