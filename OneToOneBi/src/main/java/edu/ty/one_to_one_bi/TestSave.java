package edu.ty.one_to_one_bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Car car=new Car();
		car.setId(4);
		car.setBrand("tata");
		car.setPrice(1550000);
		
		Engine engine=new Engine();
		engine.setId(104);
		engine.setType("rig");
		engine.setCc(4000);
		engine.setCar(car);
		car.setEngine(engine);
		
		entityTransaction.begin();
		entityManager.persist(car);
		entityManager.persist(engine);
		entityTransaction.commit();
	}

}
