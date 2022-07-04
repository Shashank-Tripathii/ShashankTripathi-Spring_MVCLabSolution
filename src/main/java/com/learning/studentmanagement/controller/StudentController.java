package com.learning.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.studentmanagement.model.Student;
import com.learning.studentmanagement.service.StudentInterface;

@Controller
@RequestMapping("/student")
public class StudentController {

	// For the bean to create object of studentInterface
	@Autowired
	private StudentInterface studentInterface;

	// To direct the request for adding new student to the student add form
	@RequestMapping("/addform")
	public String showForm(Model model) {
		Student student = new Student();
		model.addAttribute("mode", "Add");
		model.addAttribute("studentObj", student);
		return "student-form";
	}

	// To direct the request for listing all students in a page with list of all
	// students through JSP page
	@RequestMapping("/list")
	public String showStudents(Model model) {
		List<Student> students = studentInterface.findAllStudent();
		model.addAttribute("students", students);
		System.out.println(students);
		return "student-list";
	}

	// Post Request for saving(when ID is 0) or updating(when ID is not NULL) the
	// student details.
	// On the save Request the parameters are sent through JSP form will be received
	// here and take care
	@PostMapping("/save")
	public String saveStudent(@RequestParam(name = "id") int id, @RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName,
			@RequestParam(name = "studentCourse") String studentCourse,
			@RequestParam(name = "studentCountry") String studentCountry) {
		System.out.println("inside save save" + id + " " + firstName);
		Student student = null;

		// checking if its for add new student
		if (id == 0) {
			student = new Student(firstName, lastName, studentCourse, studentCountry);
			System.out.println(student);
			// if not its a request for Update
		} else {
			student = studentInterface.findStudentById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setStudentCourse(studentCourse);
			student.setStudentCountry(studentCountry);
		}
		System.out.println(student);
		studentInterface.saveStudent(student);
		return "redirect:list";
	}

	// Delete the student object
	@RequestMapping("/removeStudent")
	public String removeStudent(@RequestParam(name = "id") int id) {
		System.out.println("id is" + id);
		studentInterface.deleteStudentById(id);
		return "redirect:list";
	}

	// For all the update request, pass the data using model attribute to the jsp
	// student add/update form
	@RequestMapping("/updateStudent")
	public String updateStudent(@RequestParam(name = "id") int id, Model model) {
		Student student = studentInterface.findStudentById(id);
		model.addAttribute("mode", "Update");
		model.addAttribute("studentObj", student);

		return "student-form";
	}

}
