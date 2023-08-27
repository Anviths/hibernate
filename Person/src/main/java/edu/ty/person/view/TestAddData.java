package edu.ty.person.view;

import edu.ty.person.controller.PersonController;

public class TestAddData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonController controller=new PersonController();	
	       
//      controller.addPerson(create);
		 PersonView view = new PersonView();
			controller.addPerson(view.createPerson());
	}

}
