package edu.ty.studentapp.bean;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction =entityManager.getTransaction();
	
		entityTransaction.begin();
		Student s=entityManager.find(Student.class, 1);
		System.out.println("***************************");
		if(s!=null) {
			s.setStudent_height(6.0);
			entityManager.persist(s);
			entityTransaction.commit();
			System.out.println("record updated");
		}
		else {
			System.out.println("no record found");
		}
	}
}
