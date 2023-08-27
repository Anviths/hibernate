package edu.ty.person.view;

import edu.ty.person.controller.PersonController;

public class TestRemoveData {

	public static void main(String[] args) {
		PersonController controller=new PersonController();	
	       
      controller.deletePersonById(102);

	}

}
