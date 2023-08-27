package edu.ty.studentapp.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDelete {

	public static void main(String[] args) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		System.out.println("********************");
		
		Student s=em.find(Student.class, 1);
		if(s!=null) {
			em.remove(s);
			et.commit();
			System.out.println("************************************");
			System.out.println("data deleted");
		}
		else {
			System.out.println("*********************************");
			System.out.println("data not found");
		}
	}

}
