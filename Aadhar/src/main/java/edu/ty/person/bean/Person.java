package edu.ty.person.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import edu.ty.Aadhar.model.Aadhar;

@Entity
public class Person {
	@Id
	private int id;
	private String name;
	private String address;
	private long phone_number;
	private int pincode;
	@OneToOne
	@JoinColumn(name = "aadhar_id")
	private Aadhar aadharCard;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Aadhar getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(Aadhar aadharCard) {
		this.aadharCard = aadharCard;
	}

	
	
}
