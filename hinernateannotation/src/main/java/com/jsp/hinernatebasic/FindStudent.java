package com.jsp.hinernatebasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FindStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		EntityManager em=emf.createEntityManager();
//		EntityTransaction et=em.getTransaction();
		
		
		Student s=em.find(Student.class,2);
		System.out.println(s.getEmail());
	
	}

}
