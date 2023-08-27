package edu.ty.one_to_one_bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDelete {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Car car = entityManager.find(Car.class, 4);
		if (car != null) {
//			car.setEngine(null);
			Engine e=car.getEngine();
			entityManager.merge(car);
			entityManager.remove(e);
			entityTransaction.commit();
		}
	}
}
