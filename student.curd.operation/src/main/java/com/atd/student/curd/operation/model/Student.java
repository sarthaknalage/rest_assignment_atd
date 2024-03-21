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
	private String sdtName;
	
	@Column(name = "std_mobile")
	private Long stdMobile;
	
	@Column(name = "std_mail")
	private String stdMail;

	public Student() {
		
	}

	public Student(String sdtName, Long stdMobile, String stdMail) {
		super();
		this.sdtName = sdtName;
		this.stdMobile = stdMobile;
		this.stdMail = stdMail;
	}

	public Short getStdRollNumber() {
		return stdRollNumber;
	}

	public String getSdtName() {
		return sdtName;
	}

	public void setSdtName(String sdtName) {
		this.sdtName = sdtName;
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
		return "Student [stdRollNumber=" + stdRollNumber + ", sdtName=" + sdtName + ", stdMobile=" + stdMobile
				+ ", stdMail=" + stdMail + "]";
	}
	
	
}
