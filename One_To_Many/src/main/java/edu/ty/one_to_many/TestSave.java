package edu.ty.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank bank=new Bank();
		bank.setId(2);
		bank.setName("sbi");
		bank.setIfsc("sbi1234");
		Accounts account1= new Accounts();
		account1.setId(104);
		account1.setNumber(58952369);
		account1.setBalance(10000);
		Accounts account2= new Accounts();
		account2.setId(105);
		account2.setNumber(58952369);
		account2.setBalance(1000);
		Accounts account3= new Accounts();
		account3.setId(106);
		account3.setNumber(589852369);
		account3.setBalance(45000);
		List<Accounts> list=new ArrayList<Accounts>();
		list.add(account1);
		list.add(account2);
		list.add(account3);
		
		bank.setAccounts(list);
		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityManager.persist(account3);
		entityTransaction.commit();
		
	}

}
