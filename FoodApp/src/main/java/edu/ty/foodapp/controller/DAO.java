package edu.ty.foodapp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.ty.foodapp.branch.model.Branch;
import edu.ty.foodapp.foodorder.model.FoodOrder;
import edu.ty.foodapp.foodorder.model.OrderTime;
import edu.ty.foodapp.foodproduct.model.AailiabilityType;
import edu.ty.foodapp.foodproduct.model.FoodProduct;
import edu.ty.foodapp.foodproduct.model.FoodType;
import edu.ty.foodapp.item.model.Item;
import edu.ty.foodapp.item.model.ItemType;
import edu.ty.foodapp.menu.model.Menu;
import edu.ty.foodapp.user.model.User;
import edu.ty.foodapp.user.model.UserRole;

public class DAO {
	/*
	 * Entity manager class
	 */
	public Scanner scanner = new Scanner(System.in);
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	/*
	 * insert user
	 */
	public void insertUser() {
		entityTransaction.begin();
		createUser();
		entityTransaction.commit();

	}

	/*
	 * create user entity
	 */
	public User createUser() {
		User user = new User();
		System.out.println("enter the user name");
		scanner.nextLine();
		user.setName(scanner.nextLine());
		System.out.println("Enter the user email");
		user.setEmail(scanner.next().toLowerCase());
		System.out.println("enter the password");
		user.setPassword(scanner.next());
		System.out.println("choose the role \n1.admin \n2.branchManager \n3.staff");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			user.setRole(UserRole.ADMIN);
			break;
		case 2:
			user.setRole(UserRole.BRANCHMANAGER);
			break;
		case 3:
			user.setRole(UserRole.STAFF);
			break;
		default:
			user.setRole(UserRole.STAFF);
		}

		// menu
		if (user.getRole() == UserRole.ADMIN) {
			Menu menu = createMenu();
			menu.setUser(user);
			user.setMenu(menu);
		}
		// branches
		if (user.getRole() == UserRole.BRANCHMANAGER) {
			System.out.println("enter number of branches");
			int numberOfBranches = scanner.nextInt();
			List<Branch> branchs = new ArrayList<Branch>();
			for (int i = 0; i < numberOfBranches; i++) {
				Branch branch = createBranch();
				branch.setUser(user);
				branchs.add(branch);
			}
			user.setBranchs(branchs);
		}
		// Food order
		if (user.getRole() == UserRole.STAFF) {
			System.out.println("enter number of foodorder");
			int numberOfFoodOrder = scanner.nextInt();
			List<FoodOrder> foodOrders = new ArrayList<FoodOrder>();
			for (int i = 0; i < numberOfFoodOrder; i++) {
				FoodOrder foodOrder = createFoodOrder();
				foodOrder.setUser(user);
				foodOrders.add(foodOrder);
			}
			user.setFoodOrders(foodOrders);
		}
		entityManager.persist(user);
		return user;
	}
	/*
	 * food order creation
	 */

	public FoodOrder createFoodOrder() {
		FoodOrder foodOrder = new FoodOrder();
		System.out.println("enter order status");
		foodOrder.setStatus(scanner.next());
		foodOrder.setTimorderCreatedTime(LocalDateTime.now());
		System.out.println("enter customer name");
		scanner.nextLine();
		foodOrder.setCustomerName(scanner.nextLine());
		System.out.println("enter the customer number");
		foodOrder.setContactNumber(scanner.next());
		System.out.println("Select the food order delivery time \n1.10minites ");
		System.out.println("2.15 minutes \n3.20 minutes \n4.30 minutes ");
		System.out.println("5.45 minutes \n6.1 hour ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			foodOrder.setOrderDeliveryTime(OrderTime._10MIN);
			break;
		case 2:
			foodOrder.setOrderDeliveryTime(OrderTime._15MIN);
			break;
		case 3:
			foodOrder.setOrderDeliveryTime(OrderTime._20MIN);
			break;
		case 4:
			foodOrder.setOrderDeliveryTime(OrderTime._30MIN);
			break;
		case 5:
			foodOrder.setOrderDeliveryTime(OrderTime._45MIN);
			break;
		case 6:
			foodOrder.setOrderDeliveryTime(OrderTime._1HOUR);
			break;

		default:
			break;
		}
		System.out.println("enter number of items");
		int numberOfItems = scanner.nextInt();
		double totalPrice=0;
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i < numberOfItems; i++) {
			Item item = createItem();
			item.setFoodOrder(foodOrder);
			totalPrice+=item.getPrice();
			items.add(item);
		}
		// return the list of orders to user
		foodOrder.setTotalPrice(totalPrice);
		foodOrder.setItems(items);
		entityManager.persist(foodOrder);
		return foodOrder;
	}
	/*
	 * branch creation
	 */

	public Branch createBranch() {
		// creating the branch
		Branch branch = new Branch();
		System.out.println("enter the branch name");
		scanner.nextLine();
		branch.setName(scanner.nextLine());
		System.out.println("enter the branch address");
		branch.setAddress(scanner.nextLine());
		System.out.println("enter the branch phone number");
		branch.setPhoneNumber(scanner.next());
		System.out.println("enter the branch email");
		branch.setEmail(scanner.next());
		entityManager.persist(branch);
		return branch;
	}

	/*
	 * create the menu and return to caller
	 */
	public Menu createMenu() {
		Menu menu = new Menu();
		System.out.println("enter number of food product");
		int n = scanner.nextInt();
		List<FoodProduct> foodProducts = new ArrayList<FoodProduct>();

		for (int i = 0; i < n; i++) {
			FoodProduct foodProduct = createFoodProduct();
			foodProduct.setMenu(menu);
			foodProducts.add(foodProduct);
		}
		menu.setFoodProducts(foodProducts);
		entityManager.persist(menu);
		return menu;
	}
	/*
	 * food product creation
	 */

	public FoodProduct createFoodProduct() {
		FoodProduct foodProduct = new FoodProduct();
		System.out.println("enter the food name ");
		scanner.nextLine();
		foodProduct.setName(scanner.nextLine());
		System.out.println("SELECT the food type \n1.VEG \n2.NONVEG");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			foodProduct.setType(FoodType.VEG);
			break;
		case 2:
			foodProduct.setType(FoodType.NONVEG);
			break;
		default:
			foodProduct.setType(FoodType.NONVEG);
		}
		System.out.println("enter about food");
		scanner.nextLine();
		foodProduct.setAbout(scanner.nextLine());
		System.out.println("choose availblity \n1.Available  \n2.Not-availabile");
		int key = scanner.nextInt();
		switch (key) {
		case 1:
			foodProduct.setAvaliability(AailiabilityType.AVAILABLE);
			break;

		default:
			foodProduct.setAvaliability(AailiabilityType.NOT_AVAILABLE);

		}
		System.out.println("enter the price");
		foodProduct.setPrice(scanner.nextDouble());
		entityManager.persist(foodProduct);
		return foodProduct;
	}
	/*
	 * item creation
	 */

	public Item createItem() {
		Item item = new Item();

		System.out.println("enter product id");
		item.setProductId(scanner.nextInt());
		System.out.println("enter product name");
		scanner.nextLine();
		item.setName(scanner.nextLine());
		System.out.println("SELECT the food type \n1.VEG \n2.NONVEG");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			item.setType(ItemType.VEG);
			break;
		case 2:
			item.setType(ItemType.NONVEG);
			break;
		default:
			item.setType(ItemType.NONVEG);
		}
		System.out.println("enter the quantity");
		item.setQuantity(scanner.nextDouble());
		System.out.println("enter the price");
		item.setPrice(scanner.nextDouble());
		entityManager.persist(item);
		return item;
	}
   
	public void userLogin(String email,String password) {
		Query query=entityManager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> resultList = query.getResultList();
		User user=null;
		if(!resultList.isEmpty()) {
			for (User users : resultList) {
				user=users;
			}
			
		}
		if(user!=null) {
		System.out.println("user id " + user.getId());
		System.out.println("user name " + user.getName());
		System.out.println("user email " + user.getEmail());
		System.out.println("user role "+user.getRole());
		}
		else
			System.out.println("invalid password");
	}
	public void userFindById(int id) {
		User user = entityManager.find(User.class, id);
		System.out.println("user id " + user.getId());
		System.out.println("user name " + user.getName());
		System.out.println("user email " + user.getEmail());
		System.out.println("user ");
		List<Branch> branchs = user.getBranchs();
		for (Branch branch : branchs) {
			System.out.println("branch name " + branch.getName());
			System.out.println("branch phone " + branch.getPhoneNumber());
		}
		Menu menu = user.getMenu();
		List<FoodProduct> foodProducts = menu.getFoodProducts();
		for (FoodProduct foodProduct : foodProducts) {
			System.out.println("food name " + foodProduct.getName());
			System.out.println("food price " + foodProduct.getPrice());
		}

	}

	public void updatefoodProductPriceByUserId(int id, double price) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
			Menu menu = user.getMenu();
			List<FoodProduct> foodProducts = menu.getFoodProducts();
			for (FoodProduct foodProduct : foodProducts) {
				if (foodProduct.getName().equalsIgnoreCase("burger")) {
					foodProduct.setPrice(price);
					entityTransaction.begin();
					entityManager.merge(foodProduct);
					entityTransaction.commit();
				}
			}
		}
	}

	public void deleteUser(int id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
		}
	}
}
