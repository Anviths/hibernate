package edu.ty.person.view;

import java.util.Scanner;

import edu.ty.person.bean.PanCard;
import edu.ty.person.bean.Person;
import edu.ty.person.controller.PersonController;

public class PersonView {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		PersonController controller = new PersonController();
		PersonView view = new PersonView();
		controller.getpersonByPanNumber();
//	controller.addPerson(view.createPerson());

//		Person person = controller.findPersonById(101);
//		System.out.println(person);
//		PanCard card = person.getPerson_pancard();
//		System.out.println(card);
//       
//       controller.updatePersonNameById(101, "anvith");
	}
//		

	public Person createPerson() {
		Person person = new Person();
		PanCard card = new PanCard();
		System.out.println("Enter the Person id");
		person.setPerson_id(scanner.nextInt());
		System.out.println("enter the name");
		person.setPerson_name(scanner.next());
		System.out.println("enter the address");
		person.setPerson_address(scanner.next());
		System.out.println("enter the phone");
		person.setPerson_phone_number(scanner.nextLong());
		System.out.println("enter the pincode");
		person.setPerson_pincode(scanner.nextInt());
		System.out.println("enter the pancard id");
		card.setPancard_id(scanner.nextInt());
		System.out.println("enter the pancard number");
		card.setPancard_number(scanner.next());
		System.out.println("enter person full name");
		scanner.nextLine();
		card.setFull_name(scanner.nextLine());
		System.out.println("enter permanent address");
		card.setPermanant_address(scanner.nextLine());
		person.setPerson_pancard(card);
		return person;
	}

}
