package com.atd.student.curd.operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atd.student.curd.operation.model.Student;
import com.atd.student.curd.operation.service.InterStudentService;

// This layer is call by Rest-end points
@Controller
public class ControllerStudent {
	@Autowired
	private InterStudentService implStudentService;
	
	//Inserting Student Object
	
	public Student insertStudent(Student student) {
		return implStudentService.saveStudent(student);
	}
	
	// read student object
	
	public Student getStudent(Short id) {
		return implStudentService.getStudentById(id);
	}
	
//	updating student object
	public Student updateStudent(Student student) {
		return implStudentService.updateStudent(student);
	}
//	deleting student object
	public Boolean deleteStudent(Short id) {
		return implStudentService.deleteStudentById(id);
	}
}
