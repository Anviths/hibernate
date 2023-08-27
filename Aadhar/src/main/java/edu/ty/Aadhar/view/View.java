package edu.ty.Aadhar.view;

import edu.ty.Aadhar.controller.DAO;

public class View {

	public static void main(String[] args) {

		DAO dao=new DAO();
		dao.createPerson();
	}

}
