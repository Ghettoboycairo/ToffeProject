package toffe;

import java.util.HashMap;
import java.util.Scanner;

public class AdminManager{
	protected Boolean loggedIn = false;
	protected HashMap<String,String> adminLog = new HashMap<>();      //the adminLog hashmap saves the all the existing AdminManager accounts
	
	AdminManager(){                    //AdminManager constructor
		adminLog.put("admin", "admin");
	}                          
	
	protected void signUp() {   //adds the new account credentials to the hashMap
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose A Username: ");
		String name = scan.next();
		System.out.println("Choose A Password: ");
		String password = scan.next();
		
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
		System.out.println("Enter Your Username: ");
		String name = scan.next();
		System.out.println("Enter Your Password: ");
		String password = scan.next();
		if(adminLog.get(name).equals(password)) {
			loggedIn=true;
			System.out.println(name+" logged in as Admin.");
		}
		else {
			System.out.println("Account Don't exist");
		}
	}
	
	public void signOut() {     //this one is obvious :)
		loggedIn = false;
	}
	
	protected void addItemToCategory(Category c ,Item i) {          //adds existing Item to Catalog
		c.itemList.add(i);
	}
	
	protected void addNewItem(Catalog Catalog) {         //creates and adds a new Item to the Catalog
		Catalog.viewAllCategories();;
		System.out.println("Choose A Category For Your Item: ");
		Scanner scan = new Scanner(System.in);
		System.out.println();
		Integer i = scan.nextInt();
		i -= 1;
		System.out.println("Enter Item Name: ");
		String name = scan.next();
		System.out.println("Enter Item Price: ");
		Double price = scan.nextDouble();
		System.out.println("Enter Item Category: ");
		String category = scan.next();
		System.out.println("Enter Item Brand: ");
		String brand = scan.next();
		Item newItem = new Item (name,category,brand,price);
		addItemToCategory(Catalog.categoryList.get(i) , newItem);
	}
	
	protected void addNewCategory(Catalog c) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter A Name For The New Category: ");
		String name = scan.next();
		new Category(name,c);
	}	
}
