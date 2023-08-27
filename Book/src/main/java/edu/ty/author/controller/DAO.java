package edu.ty.author.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.ty.author.model.Author;
import edu.ty.book.model.Book;

public class DAO {

	Scanner scanner = new Scanner(System.in);
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void addBook() {

		Author author = new Author();

		System.out.println("enter author id");
		author.setId(scanner.nextInt());
		System.out.println("enter author name");
		scanner.nextLine();
		author.setName(scanner.nextLine());
		System.out.println("enter the author age");
		author.setAge(scanner.nextInt());
		System.out.println("enter the number of books ");
		entityTransaction.begin();
		int number = scanner.nextInt();
		for (int i = 0; i < number; i++) {
			Book book = new Book();
			System.out.println("enter the id");
			book.setId(scanner.nextInt());
			System.out.println("enter the title");
			scanner.nextLine();
			book.setTitle(scanner.nextLine());
			System.out.println("enter the publ year");
			book.setPublicationYear(scanner.nextInt());
			System.out.println("enter the price");
			book.setPrice(scanner.nextDouble());
			book.setAuthor(author);
			entityManager.persist(book);
		}
		entityManager.persist(author);
		entityTransaction.commit();
	}

	public Book findBook(int id) {

		return entityManager.find(Book.class, id);
	}

	public void print(int id) {
		Book book = findBook(id);
		if (book != null) {
			System.out.println(book);

		} else {
			System.out.println("no record found");
		}
	}

	public void updateBookPriceById(int id, double price) {
		Book book = findBook(id);
		if (book != null) {
			entityTransaction.begin();
			book.setPrice(price);
			entityManager.merge(book);
			entityTransaction.commit();
		} else {
			System.out.println("no record found");
		}
	}

	public void deleteBookById(int id) {
		Book book = findBook(id);
		if (book != null) {
			entityTransaction.begin();

			entityManager.remove(book);
			entityTransaction.commit();
		} else {
			System.out.println("no record found");
		}
	}

	public void updateAuthorNameByBookId(int id, String name) {
		Book book = findBook(id);
		if (book != null) {
			entityTransaction.begin();
			Author author = book.getAuthor();
			author.setName(name);
			entityManager.merge(author);
//			entityManager.merge(book);
			entityTransaction.commit();
		} else {
			System.out.println("no record found");
		}
	}

	public void findBookByAuthorName(String name) {
		Query query = entityManager.createQuery("select s from Book s where s.author.name=?1");
		query.setParameter(1, name);
		List<Book> books = query.getResultList();
		for (Book book : books) {
			System.out.println(book);
		}
	}

	public void totalPrice() {
		Query query = entityManager.createQuery("select SUM(s.price) from Book s");
//		query.setParameter(1, name);
		Object l =  query.getSingleResult(); 
		System.out.println(l);
		System.out.println(10.2%5);
	}
	public void allBooks() {
		Query query=entityManager.createQuery("select b.title,a.name from Book b inner join b.author a  ");
		List resultList = query.getResultList();
		for(Object res:resultList) {
			Object row[]=(Object[])res;
			
			System.out.println(row[0]+"\t:\t "+row[1]);
		}
//		System.out.println(resultList);
	}
}
