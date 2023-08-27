package edu.ty.company.view;

import edu.ty.company.controller.CompanyController;

public class CompanyView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CompanyController companyController=new CompanyController();
//		companyController.createCompany();
//		companyController.find(2);
		companyController.update(1, "python");
//		companyController.delete(2);
	}

}
