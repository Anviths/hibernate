package edu.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.ty.manytomany.uni.Student;
import edu.ty.manytomany.uni.Subject;

public class TestInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		// Student 1
		Student student1 = new Student();
		student1.setId(90);
		student1.setName("ksb");
		student1.setEmail("akshay@gmsil.com");
		// Student 2
		Student student2 = new Student();
		student2.setId(60);
		student2.setName("punith");
		student2.setEmail("raju@gmsil.com");
		//Subject 1
		Subject subject1 = new Subject();
		subject1.setId(50);
		subject1.setName("esw");
		subject1.setDays(90);
     //subject2
//		Subject subject2=new Subject();
//		subject2.setId(102);
//		subject2.setName("program");
//		subject2.setDays(90);
//   //subject3
//		Subject subject3=new Subject();
//		subject3.setId(103);
//		subject3.setName("react");
//		subject3.setDays(90);

		Subject subject2 = entityManager.find(Subject.class, 102);
		Subject subject3 = entityManager.find(Subject.class, 103);
//	

		student1.setSubjects(Arrays.asList(subject1, subject2, subject3));
		student2.setSubjects(Arrays.asList(subject1, subject2, subject3));
		
		List<Student> studentsSubject1=subject2.getStudents();
		studentsSubject1.add(student2);
		studentsSubject1.add(student1);
		List<Student> studentsSubject2=subject3.getStudents();
		studentsSubject1.add(student2);
		studentsSubject1.add(student1);
		
		subject1.setStudents(Arrays.asList(student1,student2));
//		subject2.setStudents(studentsSubject2);
//		subject2.setStudents(studentsSubject1);
//		subject2.setStudents(Arrays.asList(student1,student2));
//		subject3.setStudents(Arrays.asList(student1,student2));



		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		//subjects
		entityManager.persist(subject1);
		entityManager.merge(subject2);
		entityManager.merge(subject3);

		entityTransaction.commit();

	}

}
