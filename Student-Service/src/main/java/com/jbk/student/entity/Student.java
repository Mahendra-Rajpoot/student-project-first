package com.jbk.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
@Id
    @Column(name="id")
	private String id;
    @Column(name="student_name")
	private String studentName;
    @Column(name="marks")
	private Integer marks;
	@Column(name="branch_id")
	private Integer branchId;
	
	public Student(){}

	public Student(String id, String studentName, Integer marks, Integer branchId) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.marks = marks;
		this.branchId = branchId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", marks=" + marks + ", branchId=" + branchId
				+ "]";
	}
	

}
