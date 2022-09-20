package com.greatlearning.springMVCLabsession.service;

import java.util.List;

import com.greatlearning.springMVCLabsession.model.Student;

public interface StudentDao {

	public void saveOrUpdateStudent(Student student);
	public void deleteStudent(int id);
	public List<Student> showAll();
	public Student getStudent(int id);
}
