package com.greatlearning.springMVCLabsession.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.greatlearning.springMVCLabsession.model.Student;

@Component
@Repository
public class StudentDaoImpl implements StudentDao {

	private SessionFactory sessionfactory;

	private Session session;

	private Transaction tx;

	@Autowired
	private HibernateTemplate hibernateTemplate;

	StudentDaoImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		try {
			session = sessionfactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionfactory.openSession();
		}
	}

	@Override
	@Transactional
	public void saveOrUpdateStudent(Student student) {

		tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();

	}

	@Override
	@Transactional
	public void deleteStudent(int id) {

		tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		tx.commit();

	}

	@Override
	@Transactional
	public List<Student> showAll() {

		tx = session.beginTransaction();
		List<Student> student = session.createQuery("from Student").list();
		tx.commit();
		return student;

	}

	public Student getStudent(int id) {
		return this.hibernateTemplate.get(Student.class, id);
	}

}
