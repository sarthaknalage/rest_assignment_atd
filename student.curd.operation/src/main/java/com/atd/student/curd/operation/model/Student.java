package com.atd.student.curd.operation.model;

import com.atd.student.curd.operation.customExceptions.StudentAgeException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "std_roll")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="std_gen-1")
	@SequenceGenerator(name = "std_gen-1", sequenceName = "student_id_generator",initialValue = 1, allocationSize = 1)
	private Short stdRollNumber;
	
	@Column(name = "std_name")
	private String stdName;
	
	@Column(name = "std_mobile")
	private Long stdMobile;
	
	@Column(name = "std_mail")
	private String stdMail;
	
	@Column(name="std_age")
	private Short stdAge;
	
	
	public Student() {
		
	}
	
	public Student(Short stdRollNumber, String sdtName, Long stdMobile, String stdMail, Short stdAge) {
		super();
		this.stdRollNumber = stdRollNumber;
		this.stdName = sdtName;
		this.stdMobile = stdMobile;
		this.stdMail = stdMail;
		this.stdAge = stdAge;
	}


	public Short getStdAge() {
		return stdAge;
	}

	public void setStdAge(Short stdAge) {
		this.stdAge = stdAge;
	}

	public Short getStdRollNumber() {
		return stdRollNumber;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String sdtName) {
		this.stdName = sdtName;
	}

	public Long getStdMobile() {
		return stdMobile;
	}

	public void setStdMobile(Long stdMobile) {
		this.stdMobile = stdMobile;
	}

	public String getStdMail() {
		return stdMail;
	}

	public void setStdMail(String stdMail) {
		this.stdMail = stdMail;
	}
	
	@Override
	public String toString() {
		return "Student [stdRollNumber=" + stdRollNumber + ", sdtName=" + stdName + ", stdMobile=" + stdMobile
				+ ", stdMail=" + stdMail + ", stdAge=" + stdAge + "]";
	}
	
	
}
