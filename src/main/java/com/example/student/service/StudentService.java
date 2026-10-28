package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public List<Student> searchByDept(String dept) {
		return studentRepository.findByDepartmentIgnoreCase(dept);
	}

	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}
}
