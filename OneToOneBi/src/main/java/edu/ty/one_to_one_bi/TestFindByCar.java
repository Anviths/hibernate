package edu.ty.one_to_one_bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestFindByCar {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Car car=entityManager.find(Car.class, 3);
		if(car!=null) {
			System.out.println("---------Car--------------------");
			System.out.println("----------=---------------------");
			System.out.println("car id : "+car.getId());
			System.out.println("car brand : "+car.getBrand());
			System.out.println("car price : "+car.getPrice());
			Engine engine=car.getEngine();
			System.out.println("----------Engine----------------");
			System.out.println("Engine id  : "+engine.getId());
			System.out.println("Engine type  : "+engine.getType());
			System.out.println("Engine cc  : "+engine.getCc());
		}
		
		
	}

}
