package toffe;

import java.util.HashMap;
import java.util.Scanner;

public class customer{
	protected HashMap<String,String> customerNameToAddressLog = new HashMap<>();      //holds the adresses of the customers (name to address)
	protected HashMap<String,String> customerNameToPasswordLog = new HashMap<>();     //holds the accounts of the customers (name to password)
	protected String userName;
	protected String userPassword;
	protected String userAddress;
	protected Boolean loggedIn;
	
 	protected void signUp() {  //creates a a new customer account
 		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String name = scan.next();
		System.out.println("Enter Password: ");
		String password = scan.next();
		String address = scan.next();
 		if(customerNameToPasswordLog.containsKey(name)!=true) {
			customerNameToPasswordLog.put(name, password);
			customerNameToAddressLog.put(name, address);
			System.out.println("Customer account created succesfuly with user name: "+ name);
		}
		else if(customerNameToPasswordLog.containsKey(name)==true) {
			System.out.println("account already exist");
		}
		else {
			System.out.println("you messed up");
		}
	}

	public void signIn() {                                //signs the customer in and changes the loggedIn boolean to true
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String name = scan.next();
		System.out.println("Enter Password: ");
		String password = scan.next();
		if(customerNameToPasswordLog.get(name)==null) {
			System.out.println("Account don't exist ");
		}
		else if(customerNameToPasswordLog.get(name).equals(password)) {
			loggedIn=true;
			System.out.println(name+" Logged In As A Customer.");
		}
		else{
			System.out.println("Error Logging In ");
		}
	}


}
