package com.jbk.student.service;

import java.util.List;

import com.jbk.student.entity.Student;
import com.jbk.student.model.Branch;

public interface StudentService {
public Student saveStudent(Student student);
public Student updateStudent(Student student);
public Student getStudentById(String id);
public List<Student> getAllStudent();
public Branch getBranchById(Integer id);
}
