package edu.ty.one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarFetch {

	public static void main(String[] args) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Car car=em.find(Car.class, 101);
		if(car!=null) {
			System.out.println("-----------------------------------------");
			System.out.println("Car id : "+car.getId());
			System.out.println("Car name : "+car.getName());
			System.out.println("Car price : "+car.getPrice());
			Engine engine=car.getEngine();
			System.out.println("Engine id "+engine.getId());
			System.out.println("Engine type "+engine.getType());
			System.out.println("Engine cc "+engine.getCc());
		}
		else
			System.out.println("no record found.....!");
	}

}
