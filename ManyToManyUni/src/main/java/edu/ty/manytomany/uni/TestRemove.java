package edu.ty.manytomany.uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestRemove {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student=entityManager.find(Student.class, 1);
		if(student!=null) {
			
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		System.out.println("deleted..!");
		}
		else {
			System.out.println("no record found");
		}
	
	}

}
