package com.atd.student.curd.operation.service;

import com.atd.student.curd.operation.model.Student;

public interface InterStudentService {
//	insert the student object in db and clear the cache
	Student saveStudent(Student student);
	
//	read student by its id
	Student getStudentById(Short id);
	
//	update Student by passing updated props of student with the same existing id
	
	Student updateStudent(Student student);
	
// delete Student by providing its id and return type is boolean
	Boolean deleteStudentById(Short id);
}
