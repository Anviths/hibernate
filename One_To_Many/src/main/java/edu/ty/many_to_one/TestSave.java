package edu.ty.many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Product product=new Product();
		product.setId(2);
		product.setName("lg tv");
		product.setCost(10252);
		
		Review review1=new Review();
		review1.setId(3);
		review1.setHeading("average");
		review1.setMessage("good ");
		review1.setProduct(product);
		
		Review review2=new Review();
		review2.setId(4);
		review2.setHeading("hate");
		review2.setMessage("get heated up");
		review2.setProduct(product);
		
		entityTransaction.begin();
		entityManager.persist(product);
		entityManager.persist(review1);
		entityManager.persist(review2);
		entityTransaction.commit();
	}

}
