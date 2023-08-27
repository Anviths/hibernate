package edu.ty.studentapp.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
	private int student_id;
	private String student_name;
	private String student_email;
	private double student_height;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public double getStudent_height() {
		return student_height;
	}

	public void setStudent_height(double student_height) {
		this.student_height = student_height;
	}

	@Override
	public String toString() {
		return "student_id=" + student_id + ", student_name=" + student_name + ", student_email="
				+ student_email + ", student_height=" + student_height ;
	}

	
}
