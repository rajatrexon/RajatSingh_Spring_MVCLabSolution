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

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public void saveOrUpdateStudent(Student student) {

		this.hibernateTemplate.saveOrUpdate(student);

	}

	@Override
	@Transactional
	public void deleteStudent(int id) {

		Student student = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);

	}

	@Override
	@Transactional
	public List<Student> showAll() {

		List<Student> student = this.hibernateTemplate.loadAll(Student.class);

		return student;

	}

	public Student getStudent(int id) {
		return this.hibernateTemplate.get(Student.class, id);
	}

}
