package edu.ty.manytomany.uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestUpdate {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student=entityManager.find(Student.class, 1);
		if(student!=null) {
			student.setName("rahul");
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		System.out.println("updated");
		}
		else {
			System.out.println("no record found");
		}
	}

}
