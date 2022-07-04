package com.learning.studentmanagement.service;

import java.util.List;

import com.learning.studentmanagement.model.Student;

public interface StudentInterface {

	public List<Student> findAllStudent();

	public Student findStudentById(int id);

	public void deleteStudentById(int id);

	public void saveStudent(Student StudentObj);

}
