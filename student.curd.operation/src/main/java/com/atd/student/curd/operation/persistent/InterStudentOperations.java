package com.atd.student.curd.operation.persistent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atd.student.curd.operation.model.Student;

@Repository
public interface InterStudentOperations extends JpaRepository<Student,Short>{

}
