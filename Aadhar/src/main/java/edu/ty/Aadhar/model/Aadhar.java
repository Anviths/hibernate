package edu.ty.Aadhar.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import edu.ty.person.bean.Person;
@Entity
public class Aadhar {
@Id
	private int id;
	private long adharNumber;
	private String fullName;
	@OneToOne(mappedBy = "aadharCard")
	private Person person;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(long adharNumber) {
		this.adharNumber = adharNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
