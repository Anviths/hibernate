package edu.ty.Subject.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import edu.ty.student.bean.Student;

@Entity
public class Subject {

	@Id
	private long id;
	private String name;
	private int numberofDay;
	private double price;
	//one subject read by many students
	@OneToMany
	private List<Student> students;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberofDay() {
		return numberofDay;
	}
	public void setNumberofDay(int numberofDay) {
		this.numberofDay = numberofDay;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", numberofDay=" + numberofDay + ", price=" + price
				+ ", students=" + students + "]";
	}
	
	
	
	
}
