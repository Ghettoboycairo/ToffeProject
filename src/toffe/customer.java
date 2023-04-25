package toffe;

import java.util.HashMap;
import java.util.Scanner;

public class customer{
	protected HashMap<String,String> customerNameToAddressLog = new HashMap<>();
	protected HashMap<String,String> customerNameToPasswordLog = new HashMap<>();
	protected String userName;
	protected String userPassword;
	protected String userAddress;
	protected Boolean loggedIn;
	
 	protected HashMap<String, String> signUp(String name, String password, String address) {
		if(customerNameToPasswordLog.containsKey(name)!=true) {
			customerNameToPasswordLog.put(name, password);
			customerNameToAddressLog.put(name, address);
			System.out.println("Customer account created succesfuly with user name: "+ name);
		}
		else if(customerNameToPasswordLog.containsKey(name)==true) {
			System.out.println("account already exist");
		}
		else {
			System.out.println("you fucked up");
		}
		return customerNameToPasswordLog;
	}

	public Boolean signIn() {
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
		return loggedIn;
	}


}
