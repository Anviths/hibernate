package edu.ty.foodapp.foodproduct.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import edu.ty.foodapp.menu.model.Menu;

@Entity
public class FoodProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "food_product_id")
	@SequenceGenerator(name = "food_product_id", initialValue = 7000, allocationSize = 1)
	private int id;
	private String name;
	@Enumerated(EnumType.STRING)
	private FoodType type;
	private String about;
	@Enumerated(EnumType.STRING)
	private AailiabilityType avaliability;
	private double price;
	@ManyToOne
	@JoinColumn(name = "menu")
	private Menu menu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FoodType getType() {
		return type;
	}

	public void setType(FoodType type) {
		this.type = type;
	}

	public AailiabilityType getAvaliability() {
		return avaliability;
	}

	public void setAvaliability(AailiabilityType avaliability) {
		this.avaliability = avaliability;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
