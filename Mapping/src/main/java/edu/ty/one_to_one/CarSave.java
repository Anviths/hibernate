package edu.ty.one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarSave {

	public static void main(String[] args) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Car car=new Car();
		car.setId(103);
		car.setName("toyato");
		car.setPrice(178000);
		
		Engine engine=new Engine();
		engine.setId(21);
		engine.setType("xy10");
		engine.setCc(15000);
		
	
		car.setEngine(engine);

		et.begin();
		em.persist(car);
		em.persist(engine);
    	et.commit();
	}

}
