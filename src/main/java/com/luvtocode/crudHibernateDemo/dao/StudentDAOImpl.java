package com.luvtocode.crudHibernateDemo.dao;

import com.luvtocode.crudHibernateDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //define constructor for dependency Injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student order by lastname desc", Student.class);

        //return data
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findStudentByName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastname=:thedata",Student.class);

        theQuery.setParameter("thedata",lastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        //TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE id>100 email=none",Student.class);

        //theQuery.setParameter("");

        entityManager.merge(theStudent);


    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent= entityManager.find(Student.class,id);

        System.out.println("Name of the student being deleted is :"+theStudent.getFirstname());
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted= entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
