package edu.ty.studentapp.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveStudent {

	public static void main(String[] args) {
		Student student=new Student();
		student.setStudent_id(4);
		student.setStudent_name("vinay");
		student.setStudent_email("vinay@gamil.com");
		student.setStudent_height(5.9);

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		
		System.out.println("data saved");
	}

}
