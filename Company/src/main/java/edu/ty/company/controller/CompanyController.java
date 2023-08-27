package edu.ty.company.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.ty.company.bean.Company;
import edu.ty.company.bean.Employee;

public class CompanyController {

	Scanner scanner=new Scanner(System.in);
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void createCompany() {
		Company company=new Company();
		System.out.println("enter company id");
		company.setId(scanner.nextInt());
		System.out.println("enter company nmae");
		scanner.nextLine();
		company.setName(scanner.nextLine());
		System.out.println("enter company gst number");
		company.setGstNumber(scanner.next());
		System.out.println("enter company reg num");
		company.setRegstrationNumber(scanner.next());
		System.out.println("enter number of employee");
		int n=scanner.nextInt();
		List<Employee> employees=new ArrayList<Employee>();
		for(int i=0;i<n;i++) {
			Employee employee=new Employee();
			System.out.println("enter emp id");
			employee.setId(scanner.nextInt());
			System.out.println("enter emp nmae");
			employee.setName(scanner.next());
			System.out.println("enter emp email");
			employee.setEmail(scanner.next());
			System.out.println("enter emp password");
			employee.setPassword(scanner.next());
			System.out.println("enter emp phone");
			employee.setPhone(scanner.nextLong());
			employees.add(employee);
		}
		    company.setEmployees(employees);
			entityTransaction.begin();
			entityManager.persist(company);
			for (Employee employee : employees) {
				
				entityManager.persist(employee);
			}
			entityTransaction.commit();
			
		
	}
	public void addCompany(Company company) {
		entityTransaction.begin();
		entityManager.persist(company);
		
		entityManager.persist(company.getEmployees());
		entityTransaction.commit();
		
	}
	public void find(int id) {
		Company company= entityManager.find(Company.class, id);
		if(company!=null) {
		System.out.println(company);
	List<Employee> employees=company.getEmployees();
		for (Employee employee : employees) {
			
			System.out.println(employee);
		}
		}
		else {
			System.out.println("no record");
		}
	}
	public void update(int id,String name) {
		Company company= entityManager.find(Company.class, id);
		if(company!=null) {
		company.setName(name);
		entityTransaction.begin();
         entityManager.merge(company);
		entityTransaction.commit();
	}
		else {
			System.out.println("no record found");
		}
	}
	public void delete(int id) {
		Company company= entityManager.find(Company.class, id);
		if(company!=null) {
			
			entityTransaction.begin();
			entityManager.remove(company);
			List<Employee> employees=company.getEmployees();
			for (Employee employee : employees) {
				entityManager.remove(employee);
				
			}
			entityTransaction.commit();
		}
		else {
			System.out.println("no record found");
		}
	}
}
