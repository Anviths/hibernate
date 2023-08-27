package edu.ty.one_to_many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Bank bank=entityManager.find(Bank.class, 1);
		if(bank!=null) {
			
		System.out.println("bank id "+bank.getId());
		System.out.println("bank name "+bank.getName());
		System.out.println("bank ifsc "+bank.getIfsc());
		List<Accounts> accounts=bank.getAccounts();
		for (Accounts account : accounts) {
			System.out.println("Account id "+account.getId());
			System.out.println("Account num "+account.getNumber());
			System.out.println("Account balance "+account.getBalance());
		}
		}
	}

}
