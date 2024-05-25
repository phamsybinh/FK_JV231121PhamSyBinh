package com.ra.repository;

import com.ra.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements IStudentRepository{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student", Student.class).list();
    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(student);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class,id);
    }

    @Override
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(findById(id));
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student where  name like :key", Student.class)
                .setParameter("key","%"+name+"%").list();
    }
}
