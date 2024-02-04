package com.luvtocode.crudHibernateDemo.dao;

import com.luvtocode.crudHibernateDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    //create
    void save(Student theStudent);

    //read
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findStudentByName(String lastName);

    //update
    void update(Student theStudent);

    //delete
    void delete(Integer id);

    int deleteAll();
}
