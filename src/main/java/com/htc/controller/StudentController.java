package com.htc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.entity.Student;
import com.htc.repo.StudentRepo;
import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	private StudentRepo studentrepo;

	@PostMapping("/api/students")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
		return new ResponseEntity<Student>(studentrepo.save(student), HttpStatus.CREATED);
	}

	@GetMapping("/api/students")
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<>(studentrepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/api/students/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable long studentId){
		Optional<Student> student = studentrepo.findById(studentId);
		if (student.isPresent()) {
			return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/api/students/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable long studentId, 
			@RequestBody Student stud){
		Optional<Student> student = studentrepo.findById(studentId);
		if(student.isPresent()) {
			student.get().setStudentName(stud.getStudentName());
			student.get().setStudentEmail(stud.getStudentEmail());
			student.get().setStudentAddress(stud.getStudentAddress());
			student.get().setProfile(stud.getProfile());
			student.get().setDepartment(stud.getDepartment());
			student.get().setTask(stud.getTask());
			student.get().setProject(stud.getProject());
			return new ResponseEntity<Student>(studentrepo.save(student.get()), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/api/students/{studentId}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long studentId) {
		Optional<Student> student = studentrepo.findById(studentId);
		if(student.isPresent()) {
			studentrepo.deleteById(studentId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
