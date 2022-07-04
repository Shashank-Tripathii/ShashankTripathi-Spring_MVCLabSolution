package com.learning.studentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

//	@Column(name ="name", length=150)
//	private String name ="";

	@Column(name = "firstName", length = 150)
	private String firstName = "";

	@Column(name = "lastName", length = 150)
	private String lastName = "";

	@Column(name = "studentCourse", length = 150)
	private String studentCourse = "";

	@Column(name = "studentCountry", length = 150)
	private String studentCountry = "";

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String studentCourse, String studentCountry) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentCourse = studentCourse;
		this.studentCountry = studentCountry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public String getStudentCountry() {
		return studentCountry;
	}

	public void setStudentCountry(String studentCountry) {
		this.studentCountry = studentCountry;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", studentCourse="
				+ studentCourse + ", studentCountry=" + studentCountry + "]";
	}

}
