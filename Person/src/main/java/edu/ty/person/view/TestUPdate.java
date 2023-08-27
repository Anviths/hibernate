package edu.ty.person.view;

import edu.ty.person.controller.PersonController;

public class TestUPdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonController controller=new PersonController();	
	       
      controller.updatePersonNameById(101,"rahul");
	}

}
