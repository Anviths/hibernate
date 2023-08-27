package edu.ty.carapp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.ty.carapp.model.Car;

public class CarController {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager =entityManagerFactory.createEntityManager();
	 EntityTransaction entityTransaction=entityManager.getTransaction();
	public void addCar(Car car) {
	 entityTransaction.begin();
	 entityManager.persist(car);
	 entityTransaction.commit();
	}
	public Car findCarByID(int id) {
		
		Car car= entityManager.find(Car.class, id);
		if(car!=null)
		 return car;
		return null;
	}
	public boolean updateCarPriceById(int id,double newPrice) {
		boolean sucessfull=false;
		
		Car car= findCarByID(id);
		if(car!=null) {
		car.setPrice(newPrice);
		 entityTransaction.begin();
		 entityManager.merge(car);
		 entityTransaction.commit();
		 sucessfull=true;
		}
		return sucessfull;
		
	}
	public boolean removeCarById(int id) {
		boolean sucessfull=false;
		
		Car car=findCarByID(id);
		if(car!=null) {
		entityTransaction.begin();
		 entityManager.remove(car);
		 entityTransaction.commit();
		 sucessfull=true;
		}
			return sucessfull;
	}
}
