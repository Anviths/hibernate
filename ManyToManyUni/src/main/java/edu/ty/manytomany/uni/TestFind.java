package edu.ty.manytomany.uni;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestFind {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student=entityManager.find(Student.class, 1);
		System.out.println("================================");
		System.out.println("student name : "+student.getName());
		System.out.println("student id : "+student.getId());
		System.out.println("student email : "+student.getEmail());
		System.out.println("====================================");
		List<Subject> subjects=student.getSubjects();
		for (Subject subject : subjects) {
			System.out.println("--------------------------");
			System.out.println("subject id"+subject.getId());
			System.out.println("subject name"+subject.getName());
			System.out.println("subject days"+subject.getDays());
		}
	}

}
