package edu.ty.person.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.ty.person.bean.PanCard;
import edu.ty.person.bean.Person;

public class PersonController {
	Scanner scanner = new Scanner(System.in);
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void addPerson(Person person) {
		entityTransaction.begin();
		
		entityManager.persist(person);
		entityManager.persist(person.getPerson_pancard());
		entityTransaction.commit();
	}
	public Person findPersonById(int person_id) {
		return entityManager.find(Person.class, person_id);
	}
	public boolean updatePersonNameById(int person_id,String person_name) {
		boolean deleted=false;
		Person person=findPersonById(person_id);
		if(person!=null) {
			person.setPerson_name(person_name);
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
			deleted=true;
		}
		return deleted;
	}
	public boolean deletePersonById(int person_id) {
		boolean deleted=false;
		Person person=findPersonById(person_id);
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityManager.remove(person.getPerson_pancard());
			entityTransaction.commit();
			deleted=true;
		}
		return deleted;
	}
	
	public void getpersonByPanNumber() {
		Query sql=entityManager.createQuery("Select p from PanCard p where pancard_number=?1" );
		sql.setParameter(1, "hgdiucgw45");
		int id=0;
		List<PanCard> list=sql.getResultList();
		if(!list.isEmpty()) {
		
		for (PanCard card : list) {
			id=card.getPancard_id();
		}
		}
		Query sql1=entityManager.createQuery("Select p from Person p where person_pancard_pancard_id=?1");
		sql1.setParameter(1, id);
		List<Person> per=sql1.getResultList();
		for (Person person : per) {
			System.out.println(person);
		}
	}
}
