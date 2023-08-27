package edu.ty.Customer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.ty.Customer.model.Customer;
import edu.ty.product.model.Product;

public class DAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void createCustomer() {
		Customer customer=new Customer();
		customer.setId(2);
		customer.setName("kumar");
		customer.setEmail("kumar@gmail.com");
		customer.setPhone("9478528155");
		
		Product product1=new Product();
		product1.setId(104);
		product1.setName("tv");
		product1.setPrice(15000);
		product1.setCustomer(customer);
		Product product2=new Product();
		product2.setId(105);
		product2.setName("mobile");
		product2.setPrice(15000);
		product2.setCustomer(customer);
		Product product3=new Product();
		product3.setId(106);
		product3.setName("laptop");
		product3.setPrice(15000);
		product3.setCustomer(customer);
		List<Product> products=new ArrayList<Product>();
		products.add(product2);
		products.add(product3);
		products.add(product1);
		
		customer.setProducts(products);
		entityTransaction.begin();
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityManager.persist(product3);
		entityManager.persist(customer);
		entityTransaction.commit();
	}
	public Customer findCustomerById(int id) {
		return entityManager.find(Customer.class, id);
		
	}
	public Product findProductById(int id) {
		return entityManager.find(Product.class, id);
		
	}
	public void updateProductNameById(int id,String name) {
		Product product=findProductById(id);
		System.out.println(product);
		if(product!=null) {
		product.setName(name);
		entityTransaction.begin();
		entityManager.merge(product);
		entityTransaction.commit();
		System.out.println("updated");
		}
		else
			System.out.println("no data found");
	}
	public void deleteProductById(int id) {
		Product product=findProductById(id);
		if(product!=null) {
			entityTransaction.begin();
			entityManager.remove(product);
			entityTransaction.commit();
			System.out.println("deleted");
		}
		else
			System.out.println("no data found");
	}
	public void printFromCustomer(int id) {
		Customer customer=findCustomerById(id);
		if(customer!=null) {
			System.out.println("-------------------");
			System.out.println(customer.getId());
			System.out.println(customer.getEmail());
			System.out.println(customer.getName());
			System.out.println(customer.getPhone());
			
			List<Product> products=customer.getProducts();
			for (Product product : products) {
				System.out.println("===================");
				System.out.println(product.getId());
				System.out.println(product.getName());
				System.out.println(product.getPrice());
			}
		}
		else
			System.out.println("no record");
	}
	public void printFromProduct(int id) {
		Product product=findProductById(id);
		if(product!=null){
		System.out.println("===================");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
			Customer customer=product.getCustomer();
			System.out.println("-------------------");
			System.out.println(customer.getId());
			System.out.println(customer.getEmail());
			System.out.println(customer.getName());
			System.out.println(customer.getPhone());

		}
		else
			System.out.println("no record");
	}
}
