package edu.ty.many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Review r=entityManager.find(Review.class, 2);
		r.setMessage("after 1 week it nice working");
		entityTransaction.begin();
		entityManager.persist(r);
		entityTransaction.commit();
	}

}
