package toffe;

import java.util.HashMap;
import java.util.Scanner;

public class admin{
	protected Boolean loggedIn = false;
	protected HashMap<String,String> adminLog = new HashMap<>();      //the adminLog hashmap saves the all the existing admin accounts
	
	admin(){ }                          //admin constructor
	
	protected void signUp(String name, String password) {   //adds the new account credentials to the hashMap
		if(adminLog.containsKey(name)!=true) {
			adminLog.put(name, password);
			System.out.println("Admin account created succesfuly with user name: "+ name);
		}
		else if(adminLog.containsKey(name)==true) {
			System.out.println("account already exist");
		}
		else {
			System.out.println("you messed up");
		}
	}

	public void signIn() {     //checks if the given credentials exist in the hashMap and if so it changes the loggedIn boolean to true
		Scanner scan = new Scanner(System.in);
		System.out.println("enter username: ");
		String name = scan.next();
		System.out.println("enter password: ");
		String password = scan.next();
		if(adminLog.get(name)==null) {
			System.out.println("Account dont exist ");
		}
		else if(adminLog.get(name).equals(password)) {
			loggedIn=true;
			System.out.println(name+" logged in as Admin.");
		}
		else{
			System.out.println("error logging in ");
		}
	}
	
	public void signOut() {     //this one is obvious :)
		loggedIn = false;
	}
	
	protected void addItemToCatalog(catalog c ,item i) {          //adds existing item to catalog
		c.itemList.add(i);
	}
	
	protected void addNewItem(catalog catalog) {         //creates and adds a new item to the catalog
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter Item Name: ");
		String name = scan.next();
		System.out.println("Enter Item Price: ");
		Double price = scan.nextDouble();
		System.out.println("Enter Item Category: ");
		String category = scan.next();
		System.out.println("Enter Item Brand: ");
		String brand = scan.next();
		item newItem = new item (name,category,brand,price);
		addItemToCatalog(catalog , newItem);
	}
}
