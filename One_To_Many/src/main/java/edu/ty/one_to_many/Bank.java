package edu.ty.one_to_many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {
 @Id
	private int id;
	private String name;
	private String ifsc;
	@OneToMany
	private List<Accounts> accounts;
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
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public List<Accounts> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}
	
	
}
