package edu.ty.person.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int person_id;
	private String person_name;
	private String person_address;
	private long person_phone_number;
	private int person_pincode;
	@OneToOne
	private PanCard person_pancard;

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public String getPerson_address() {
		return person_address;
	}

	public void setPerson_address(String person_address) {
		this.person_address = person_address;
	}

	public long getPerson_phone_number() {
		return person_phone_number;
	}

	public void setPerson_phone_number(long person_phone_number) {
		this.person_phone_number = person_phone_number;
	}

	public int getPerson_pincode() {
		return person_pincode;
	}

	public void setPerson_pincode(int person_pincode) {
		this.person_pincode = person_pincode;
	}

	public PanCard getPerson_pancard() {
		return person_pancard;
	}

	public void setPerson_pancard(PanCard person_pancard) {
		this.person_pancard = person_pancard;
	}

	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", person_name=" + person_name + ", person_address=" + person_address
				+ ", person_phone_number=" + person_phone_number + ", person_pincode=" + person_pincode
				+ ", person_pancard=" + person_pancard + "]";
	}

	
}
