package com.jbk.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.student.entity.Student;
import com.jbk.student.model.Branch;
import com.jbk.student.service.StudentService;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	private StudentService service;
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student stu=service.saveStudent(student);
		if(stu!=null) {
		return new ResponseEntity<Student>(stu,HttpStatus.OK);
		}else {
			return new ResponseEntity<Student>(stu,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value="/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
	 
		Student stude=service.updateStudent(student);
	if(stude!=null) {
		return new  ResponseEntity<Student>(stude,HttpStatus.OK);
	}
	else {
	
		return new  ResponseEntity<Student>(stude,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudent(){
		
		List<Student> list=service.getAllStudent();
		if(list.isEmpty()) {
			return new ResponseEntity<List<Student>>(list,HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/getStudentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable String id) {
		Student student=service.getStudentById(id);
		if(student!=null) {
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}else {
		
		return new ResponseEntity<Student> (student,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getBranchById/{id}")
	public ResponseEntity<Branch> getBranchById(@PathVariable Integer id){
		Branch branch=service.getBranchById(id);
		if(branch!=null) {
			return new ResponseEntity<Branch>(branch,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(branch,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
}
