package edu.ty.Customer.view;

import edu.ty.Customer.controller.DAO;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DAO dao=new DAO();
		dao.createCustomer();
//		dao.updateProductNameById(101, "watch");
//		dao.printFromCustomer(1);
//		dao.printFromProduct(101);
		
	}

}
