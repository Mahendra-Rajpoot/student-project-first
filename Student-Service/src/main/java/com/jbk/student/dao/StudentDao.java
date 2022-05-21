package com.jbk.student.dao;

import java.util.List;

import com.jbk.student.entity.Student;

public interface StudentDao {
public Student saveStudent(Student student);
public Student updateStudent(Student student);
public Student getStudentById(String id);
public List<Student> getAllStudent();

}
