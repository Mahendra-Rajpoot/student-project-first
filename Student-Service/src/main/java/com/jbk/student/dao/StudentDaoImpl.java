package com.jbk.student.dao;

import java.util.List;

import javax.transaction.Transaction;
import javax.websocket.Session;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.student.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Student saveStudent(Student student) {
		org.hibernate.Session session=sf.openSession();
		org.hibernate.Transaction transaction=session.beginTransaction();
		
		try {
			session.save(student);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		org.hibernate.Session session=sf.openSession();
		org.hibernate.Transaction transaction=session.beginTransaction();
		
		try {
			
			session.update(student);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			session.close();
		}
			return student;
	}

	@Override
	public List<Student> getAllStudent() {
		org.hibernate.Session session=sf.openSession();
		List<Student> list=null;
		try {
			Criteria criteria=session.createCriteria(Student.class);
		 list=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return list;
	}

	@Override
	public Student getStudentById(String id) {
		org.hibernate.Session session=sf.openSession();
		Student student=null;
		try {
		 student=session.get(Student.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return student;
	}




}
