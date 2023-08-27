package edu.ty.person.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PanCard {

	@Id
	private int pancard_id;
	private String pancard_number;
	private String full_name;
	private String permanant_address;
	public int getPancard_id() {
		return pancard_id;
	}
	public void setPancard_id(int pancard_id) {
		this.pancard_id = pancard_id;
	}
	public String getPancard_number() {
		return pancard_number;
	}
	public void setPancard_number(String pancard_number) {
		this.pancard_number = pancard_number;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getPermanant_address() {
		return permanant_address;
	}
	public void setPermanant_address(String permanant_address) {
		this.permanant_address = permanant_address;
	}
	@Override
	public String toString() {
		return "PanCard [pancard_id=" + pancard_id + ", pancard_number=" + pancard_number + ", full_name=" + full_name
				+ ", permanant_address=" + permanant_address + "]";
	}
	
	
}
