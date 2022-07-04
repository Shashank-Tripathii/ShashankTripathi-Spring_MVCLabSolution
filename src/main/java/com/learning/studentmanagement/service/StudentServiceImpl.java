package com.learning.studentmanagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.studentmanagement.model.Student;

@Repository
public class StudentServiceImpl implements StudentInterface {

	// Creating object leveraging SPring
	private SessionFactory sessionFactory;
	private Session session;

	// getting the session using the factory
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		try {
			this.session = sessionFactory.getCurrentSession();

		} catch (HibernateException e) {
			this.session = sessionFactory.openSession();
		}

	}

	// Querying the table full and storing it in list for display
	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		List<Student> students = session.createQuery("from Student").list();
		return students;
	}

	// find student details by id
	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub

		Student student = session.get(Student.class, id);
		return student;
	}

	// find student by id and delete it using the id
	@Override
	@Transactional
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		System.out.println("student prop" + student);
		session.delete(student);
		tx.commit();
	}

	// Add or Save
	@Override
	@Transactional
	public void saveStudent(Student StudentObj) {
		// TODO Auto-generated method stub

		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(StudentObj);
		tx.commit();

	}

}
