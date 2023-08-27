package edu.ty.studentapp.bean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentFindAll {

	public static void main(String[] args) {

		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vikas");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Query query=em.createQuery("SELECT s FROM Student s");
		List<Student> students=query.getResultList();
		for(Student student:students) {
			System.out.println(student);
			System.out.println("==========================================================");
		}
		et.begin();
		
	}

}
