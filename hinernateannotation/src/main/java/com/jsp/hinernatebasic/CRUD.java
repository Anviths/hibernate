package com.jsp.hinernatebasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CRUD {

	public static void main(String[] args) {

		Student student=new Student();
		student.setRol(1);
		student.setName("abc");
		student.setEmail("abp@gmail.com");
		student.setHeight(6.1);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(student);
		et.commit();
		System.out.println("data saved");
	}

}
