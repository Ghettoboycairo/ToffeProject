package toffe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class admin{
	protected Boolean loggedIn = false;
	protected HashMap<String,String> adminLog = new HashMap<>();
//	protected String userName;
//	protected String userPassword;
	
	admin(){ }                          //admin constructor
	
	protected HashMap<String, String> signUp(String name, String password) {
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
		return adminLog;
	}

	public Boolean signIn() {
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
		return loggedIn;
	}
	
	public void signOut() {
		loggedIn = false;
	}
	
	protected void addItemToCatalog(catalog c ,item i) {          //adds item to catalog
		c.itemList.add(i);
	}
	
	protected ArrayList<item> addNewItem(catalog catalog) {
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
		return catalog.itemList;
	}
	
	public static void main(String[] args) {
		admin a1 = new admin();
		catalog c1 = new catalog();
		item it = new item("cola","drinks","cocacola",6.5);
		a1.addItemToCatalog(c1, it);
		c1.viewAllItems();
		a1.addNewItem(c1);
		c1.viewAllItems();
		a1.addNewItem(c1);
		c1.viewAllItems();
		//System.out.print(c1.itemList);
	}
	
	
}
