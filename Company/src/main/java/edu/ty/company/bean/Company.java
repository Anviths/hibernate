package edu.ty.company.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	private int id;
	private String name;
	private String gstNumber;
	private String regstrationNumber;
	@OneToMany
	private List<Employee> employees;
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
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getRegstrationNumber() {
		return regstrationNumber;
	}
	public void setRegstrationNumber(String regstrationNumber) {
		this.regstrationNumber = regstrationNumber;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", gstNumber=" + gstNumber + ", regstrationNumber="
				+ regstrationNumber + ", employees=" + employees + "]";
	}

	
}
