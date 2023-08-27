package edu.ty.Aadhar.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.ty.Aadhar.model.Aadhar;
import edu.ty.person.bean.Person;

public class DAO {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		public void createPerson() {
		Person person=new Person();
		person.setId(1);
		person.setName("raju");
		person.setPhone_number(1236547895l);
		person.setAddress("banglore");
		person.setPincode(560017);
		Aadhar aadhar=new Aadhar();
		aadhar.setId(101);
		aadhar.setFullName(person.getName()+"kumar");
		aadhar.setAdharNumber(74859632102l);
		aadhar.setPerson(person);
		person.setAadharCard(aadhar);
		entityTransaction.begin();
		entityManager.persist(aadhar);
		entityManager.persist(person);
		entityTransaction.commit();
	}
		public Aadhar findAadharByid(int id) {
			return entityManager.find(Aadhar.class, 101);
			
		}
		public Person findPersonId(int id) {
			
		}
}
