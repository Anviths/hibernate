package edu.ty.book.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import edu.ty.author.model.Author;

@Entity
public class Book {
   @Id
	private int id;
	private String title;
	private double price;
	private int publicationYear;
	@ManyToOne
	private Author author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", publicationYear=" + publicationYear
				+ ", author=" + author + "]";
	}
	
	
}
