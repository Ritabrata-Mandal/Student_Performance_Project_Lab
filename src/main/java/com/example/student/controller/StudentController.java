package com.example.student.controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String home(Model model,
			@RequestParam(value = "keyword", required = false) String keyword) {
		if (keyword != null && !keyword.isEmpty()) {
			model.addAttribute("students", studentService.searchByDept(keyword));
		} else {
			model.addAttribute("students", studentService.getAllStudents());
		}
		model.addAttribute("student", new Student());
		model.addAttribute("keyword", keyword);
		return "index";
	}

	@PostMapping("/add")
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id) {
		studentService.deleteStudent(id);
		return "redirect:/";
	}
}
