package com.atd.student.curd.operation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.student.curd.operation.customExceptions.StudentNotComplete;
import com.atd.student.curd.operation.customExceptions.StudentNotPresent;
import com.atd.student.curd.operation.model.Student;
import com.atd.student.curd.operation.persistent.InterStudentOperations;

@Service
public class ImplStudentService implements InterStudentService {
	
//	Autowiring the jpa created/provided impl object to this layer
	@Autowired
	InterStudentOperations interStudentOperations;
	
	
	@Override
	public Student saveStudent(Student student) {
		return (student!=null)?interStudentOperations.saveAndFlush(student):null;
	}

	@Override
	public Student getStudentById(Short id) {
		
		Optional<Student> student= interStudentOperations.findById(id);
		if(student.isPresent()) {
			return student.get();
		}
		return null;
	}

	@Override
	public Student updateStudent(Student student){

//		Here need to check first student is present or not
		if(availabilityStatus(student.getStdRollNumber())) {
//			best way is first retrieved it and then make changes inside that entity because it is present in the
//			transient state that make changes reflected to database also avoid the problem of conflict
			Student retrievedStudent=this.interStudentOperations.findById(student.getStdRollNumber()).get();
//			make the changes
			retrievedStudent.setStdName(student.getStdName());
			retrievedStudent.setStdMobile(student.getStdMobile());
			retrievedStudent.setStdMail(student.getStdMail());
			retrievedStudent.setStdAge(student.getStdAge());
//			Here ID Property is already set so need to set it one more time
			Student studentUpdated=this.interStudentOperations.saveAndFlush(retrievedStudent);
			return  studentUpdated;
		}
		return null;
	}

//	Here we write utility logic to minimize the boiler plate code
	public boolean availabilityStatus(Short id) {
		return interStudentOperations.existsById(id);
	}
	@Override
	public Boolean deleteStudentById(Short id) {
		if(availabilityStatus(id)) {
			interStudentOperations.deleteById(id);
		}
		return !availabilityStatus(id);
	}

	@Override
	public Boolean isStudentPresent(Short id) {
		return (id!=null)?interStudentOperations.existsById(id):false;
	}

}
