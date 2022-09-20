package com.greatlearning.springMVCLabsession.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.greatlearning.springMVCLabsession.model.Student;
import com.greatlearning.springMVCLabsession.service.StudentDao;

@Controller
@RequestMapping("/student_page")
public class StudentController {

	@Autowired
	private StudentDao studentdao;

	@RequestMapping("/show")
	public String showList(Model m) {
		List<Student> student = this.studentdao.showAll();
		m.addAttribute("studentsList", student);
		return "student-list";
	}
     
	
	@RequestMapping("/add-student-button")
	public String addStudent(Model m) {
       m.addAttribute("title", "Add Student");
		return "student-form";
	}
	
	
	@RequestMapping(value="/update-student" ,method=RequestMethod.POST)
	public String updateStudent(@ModelAttribute Student student,HttpServletRequest request) {
		
		
		this.studentdao.saveOrUpdateStudent(student);
		
		return "redirect:/student_page/show";
	}
	
	@RequestMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable("studentId") int id) {
		this.studentdao.deleteStudent(id);
		
		return "redirect:/student_page/show";
	}
	
	@RequestMapping("/update/{studentID}")
	public String updatehandler(@PathVariable("studentID") int id ,Model m) {
		Student student =this.studentdao.getStudent(id);
		
		m.addAttribute("student",student);
		
		return "Update-student";
	}

}
