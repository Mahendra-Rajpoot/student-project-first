package com.jbk.student.service;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jbk.student.dao.StudentDao;
import com.jbk.student.entity.Student;
import com.jbk.student.model.Branch;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public RestTemplate restTemplate;
	
@Autowired
private StudentDao dao;
	@Override
	public Student saveStudent(Student student) {
String id=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
             student.setId(id);
		Student stu	=dao.saveStudent(student);
		return stu;
	}
	@Override
	public Student updateStudent(Student student) {
		Student stu=dao.updateStudent(student);
		return stu;
	}
	@Override
	public List<Student> getAllStudent() {
		List<Student> list=dao.getAllStudent();
		return list;
	}
	@Override
	public Student getStudentById(String id) {
		Student student=dao.getStudentById(id);
		return student;
	}
	@Override
	public Branch getBranchById(Integer id) {
	       Branch branch= restTemplate.getForObject
	    		   ("http://localhost:8081/branch/getBranchById/"+id, Branch.class);
		return branch;
	}

}
