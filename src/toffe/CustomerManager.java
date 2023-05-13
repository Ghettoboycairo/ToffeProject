package toffe;
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Scanner;



public class CustomerManager{
	protected static HashMap<String,String> customerNameToAddressLog = new HashMap<>();      //holds the adresses of the customers (name to address)
	protected static HashMap<String,String> customerNameToPasswordLog = new HashMap<>();     //holds the accounts of the customers (name to password)
	protected static HashMap<String,String> customerNameToEmail = new HashMap<>();      //holds the emails of the customers (name to email)
	protected static HashMap<String,Cart> customerNameToCart = new HashMap<>();         //holds a unique Cart for each unique username in the map 
	protected static HashMap<String,ArrayList<Order>> customerNameToPreviousOrders = new HashMap<>();  //holds an array of previous orders

	
	protected String userName;

	protected Boolean loggedIn = false;

	
 	protected void signUp() {  //creates a a new CustomerManager account
 		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String name = scan.next();
		System.out.println("Enter Password: ");
		String password = scan.next();
		System.out.println("Enter Your Address: ");
		String address = scan.next();
		System.out.println("Enter Your E-mail: ");
		String email = scan.next();
		email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com");  //checks if the given email matches the correct email format
		while(email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com")!=true) {  //if not then user will have to try again
			System.out.println("Unvalid Email, Enter A Valid Email: ");
			email = scan.next();
		}
		if(customerNameToPasswordLog.containsKey(name)!=true) {
			customerNameToPasswordLog.put(name, password);
			customerNameToAddressLog.put(name, address);
			customerNameToEmail.put(name, email);
			customerNameToCart.put(name, new Cart(name));
			customerNameToPreviousOrders.put(name, new ArrayList<>());
			System.out.println("Customer account created succesfuly with user name: "+ name);
		}
		else if(customerNameToPasswordLog.containsKey(name)==true) {
			System.out.println("Account Already Exist");
		}
		else {
			System.out.println("You Messed Up...");
		}
	}
 	
	public void signIn() {              //signs the CustomerManager in and changes the loggedIn boolean to true
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your Username: ");
		String name = scan.next();
		System.out.println("Enter Your Password: ");
		String password = scan.next();
		if(customerNameToPasswordLog.containsKey(name)) {
			if(customerNameToPasswordLog.get(name).equals(password)) {
				userName = name;
				loggedIn=true;
				System.out.println("---------------------------------------");
				System.out.println("Customer "+name+" Logged In.");
			}
			else {
				System.out.println("Wrong Password.");
			}
		}
		else {
			System.out.println("Account Don't exist...");
		}
	}

	public void signOut() {     //this one is obvious :)
		loggedIn = false;
		userName = null;
	}
	

}
