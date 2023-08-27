package edu.ty.many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Review r=entityManager.find(Review.class, 2);
		System.out.println("------------------------------------");
		System.out.println("review id : "+r.getId());
		System.out.println("review heading : "+r.getHeading());
		System.out.println("review message : "+r.getMessage());
		Product p=r.getProduct();
		System.out.println("-----------------------------------");
		System.out.println("product id : "+p.getId());
		System.out.println("product name : "+p.getName());
		System.out.println("product cost :n"+p.getCost());
	}

}
