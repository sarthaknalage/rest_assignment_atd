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
			Student studentdUpdated=interStudentOperations.save(student);
			return studentdUpdated;
		}
		return null;
	}

//	Here we write utility logic to minimize the boiler plate code
	public boolean availabilityStatus(Short id) {
		boolean status=interStudentOperations.existsById(id);
		if(status) {
			return true;
		}
//		throw new StudentNotPresent("Given Requested Object with id"+ id +" is Not Present!!!");
		return false;
	}
	@Override
	public Boolean deleteStudentById(Short id) {
		if(availabilityStatus(id)) {
			interStudentOperations.deleteById(id);
		}
		return availabilityStatus(id);
	}

}
