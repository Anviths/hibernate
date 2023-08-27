package edu.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.ty.manytomany.uni.Student;
import edu.ty.manytomany.uni.Subject;

public class DAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void insertData() {
		Student student=new Student();
		student.setId(7);
		student.setName("rahul");
		student.setEmail("monoj@email.com");
		
//		Subject subject1=new Subject();
//		subject1.setId(110);
//		subject1.setName("jdbc");
//		subject1.setDays(50);
		
//		Subject subject2=new Subject();
//		subject2.setId(102);
//		subject2.setName("python");
//		subject2.setDays(30);
		Subject subject2=entityManager.find(Subject.class, 102);
//		Subject subject3=new Subject();
//		subject3.setId(103);
//		subject3.setName("sql");
//		subject3.setDays(20);
//		List<Student> students=new ArrayList<Student>();
		List<Subject> subjects =new ArrayList<Subject>();
//		subjects.add(subject3);
		subjects.add(subject2);
		subjects.add(subject1);
//		students.add(student);
//		subject1.setStudents(students);
//		subject2.setStudents(students);
//		subject3.setStudents(students);
		student.setSubjects(subjects);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(subject1);
//		entityManager.persist(subject2);
//		entityManager.persist(subject3);
		entityTransaction.commit();
	}
	public void findByStudent(int id) {
		Student student=entityManager.find(Student.class,id);
		if(student!=null) {
			System.out.println("student id : "+student.getId());
			System.out.println("student name : "+student.getName());
			System.out.println("student email : "+student.getEmail());
			List<Subject> subject=student.getSubjects();   
			
		}
	}
}
