package edu.ty.one_to_one_bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestUpdate {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Car car=entityManager.find(Car.class, 3);
		if(car!=null) {
			car.setBrand("Mg hector");
			entityTransaction.begin();
			entityManager.persist(car);
			entityTransaction.commit();
		}
	}

}
