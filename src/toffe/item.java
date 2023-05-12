package toffe;

import java.util.Scanner;

public class Item {
	private String name;
	private String category;
	private String description;
	private String brand;
	private double price;
	private double discount;
	private Integer itemId;
	private static Integer Id =0;       //used to set the Item id
	public Item(String name) {
		this.name = name;
	}
	public Item(String name, String category, String brand, double price) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.brand = brand;
		this.setId(Id);
		Id++;
	}
	
	protected void setName() {
		Scanner scan= new Scanner(System.in); 
		String n = scan.next();
		this.name= n ;
	}
	protected void setCategory() {
		Scanner scan= new Scanner(System.in); 
		String n = scan.next();
		this.category= n ;
	}
	protected void setDescription() {
		Scanner scan= new Scanner(System.in); 
		String n = scan.next();
		this.description= n ;
	}
	protected void setBrand() {
		Scanner scan= new Scanner(System.in);
		String n = scan.next();
		this.brand = n;
	}
	protected void setPrice() {
		Scanner scan= new Scanner(System.in);
		float p = scan.nextFloat();
		this.price= p;
	}
	protected void setDiscount(double d) {
		Scanner scan= new Scanner(System.in);
		float p = scan.nextFloat();
		this.discount= d;
	}
	private void setId(int Id){
		this.itemId = Id;
	}

	public String getName() {
		return this.name;
	}
	public String getCategory() {
		return this.category;
	}
	public String getDescription() {
		return this.description;
	}
	public String getBrand() {
		return this.brand;
	}
	public double getPrice() {
		return this.price;
	}
	public double getDiscount() {
		return this.discount;
	}
	public Integer getItemId() {
		return this.itemId;
	}
	@Override
    public String toString() {
		System.out.println("------------------------------------------------------");
        return "Name: "+this.name + " - Category: " + this.category +" - Describtion: "+this.description +" - Brand: "+this.brand+" - Price: "+this.price+
        		" - Discount: "+this.discount+ " - Item Id: "+this.itemId+"       ";
    }
	
}

