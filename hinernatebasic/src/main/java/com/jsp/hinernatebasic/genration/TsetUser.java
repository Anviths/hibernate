package com.jsp.hinernatebasic.genration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TsetUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User user=new User();
		user.setEmail("anw@gmsajl.com");
		user.setName("anvith");
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

}
