package com.atd.student.curd.operation.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atd.student.curd.operation.controller.ControllerStudent;
import com.atd.student.curd.operation.customExceptions.MobileNumberException;
import com.atd.student.curd.operation.customExceptions.StudentAgeException;
import com.atd.student.curd.operation.customExceptions.StudentNotComplete;
import com.atd.student.curd.operation.model.Student;

@RestController
@RequestMapping(value = "/student")
public class StudenRestController {
//	Autowiring the controller class
	@Autowired
	ControllerStudent controllerStudent;
//	utility Functionality for Exception checking
	public Boolean checkStudentCompleteOrNot(Student student)
	{
		if(student.getStdName()==null || student.getStdMail()==null || student.getStdMobile()==null || student.getStdAge()==null) {
			return false;
		}
		return true;
	}
	
	public Boolean checkStudentAgeValidity(Student student) {
		
		return student.getStdAge()>5 && student.getStdAge()<=70;
	}
	
	public Boolean checkMobileDigitCount(Long mobile) {
		return mobile.toString().length()==10;
	}
	
	
//	end point for inserting student entity
	@PostMapping(value = "/save",consumes = "application/json", produces = "application/json")
	ResponseEntity<Student> saveStudent(@RequestBody Student student)throws Exception{
//		check the student object(all required pre-condtions)
		if(!checkStudentCompleteOrNot(student)) {
			throw new StudentNotComplete("Provided Student is no complete !! please fill all required details and then save it");
		}
		if(!checkStudentAgeValidity(student)) {
			throw new StudentAgeException("Provided Student Age is "+student.getStdAge()+" which is not compatible !!");
		}
		if(!checkMobileDigitCount(student.getStdMobile())) {
			throw new MobileNumberException("Student with id "+ student.getStdRollNumber()+" enter incorrect mobile number wiht the count of "+student.getStdMobile().toString().length());
			
		}
		Student savedStudent=controllerStudent.insertStudent(student);
		
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	// read student entity
	@GetMapping(value = "/read/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Short id){
		if(id<0 || id==null) {
			throw new IllegalArgumentException("ID inserted in not Valid  "+id);
		}
		Student readStudent=controllerStudent.getStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body(readStudent);
	}
	
	@PutMapping(value = "/update", consumes = "application/json", produces="application/json")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws Exception{
		if(!checkStudentCompleteOrNot(student)) {
			throw new StudentNotComplete(null);
		}
		if(!checkStudentAgeValidity(student)) {
			throw new StudentAgeException(null);
		}
		if(!checkMobileDigitCount(student.getStdMobile())) {
			throw new MobileNumberException("Student with id "+ student.getStdRollNumber()+" enter incorrect mobile number wiht the count of "+student.getStdMobile().toString().length());
			
		}
		
		Student updatedStudent= controllerStudent.updateStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
	}
	
	// end point for delete the student entity with providing the id property
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable Short id){
		Boolean isDeleted=controllerStudent.deleteStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
	}
}
