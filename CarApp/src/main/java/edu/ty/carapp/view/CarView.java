package edu.ty.carapp.view;

import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import edu.ty.carapp.controller.CarController;
import edu.ty.carapp.model.Car;

public class CarView {

	static Scanner read=new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CarController carController=new CarController();
		System.out.println("1.add car");
		System.out.println("2.find car by id");
		System.out.println("3.update car price");
		System.out.println("4.remove car ");
		
		int key=read.nextInt();
		switch (key) {
		case 1:
			carController.addCar(createCar());
			break;
		case 2:
			print(carController.findCarByID(101));
			break;
		case 3:
			result(carController.updateCarPriceById(102,8000));
			break;
		case 4:
			result(carController.removeCarById(103));
			break;
         
		default:
			break;
		}
		
		
	}


	private static void result(boolean ans) {
		if(ans) {
			System.out.println("sucessfull");
		}
		else
			System.out.println("unsucessfull");
		
	}


	private static void print(Car car) {
		if(car!=null) {
		System.out.println("Car id= "+car.getId());
		System.out.println("Car brand= "+car.getName());
		System.out.println("car color= "+car.getEngine());
		System.out.println("Car price = "+car.getPrice());
		}
		else
			System.out.println("no record found of this id found.....!!");
	}


	private static Car createCar() {
  Car car=new Car();
  System.out.println("enter car id");
  car.setId(read.nextInt());
  System.out.println("enter the car color");
  read.nextLine();
  car.setName(read.nextLine());
  System.out.println("enter the car price");
  car.setPrice(read.nextDouble());
  System.out.println("enter the car price");
  car.setPrice(read.nextDouble());
		return car;
	}

}
