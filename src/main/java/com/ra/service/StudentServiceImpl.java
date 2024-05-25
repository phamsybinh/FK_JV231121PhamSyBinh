package com.ra.service;

import com.ra.UploadService;
import com.ra.dto.request.CreateStudentForm;
import com.ra.entity.Student;
import com.ra.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private UploadService uploadService;
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(CreateStudentForm request) {
        Student student = Student.builder()
                .name(request.getName())
                .sex(request.getSex())
                .address(request.getAddress())
                .birthday(request.getBirthday())
                .phoneNumber(request.getPhoneNumber())
                .build();
        if (request.getFile().getSize()!=0){
            String url = uploadService.uploadFileToServer(request.getFile());
            student.setImageUrl(url);
        }
        studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        studentRepository.remove(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }
}
