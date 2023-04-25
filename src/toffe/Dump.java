package toffe;

import java.util.Scanner;

public class Dump {
	static Boolean menu1=true;
	static Boolean menu2=false;
	static Scanner scan = new Scanner(System.in);
	admin a1 = new admin();
	public static void main(String[] args) {
		while(menu1==true) {
			Boolean isGuest = false;
			admin a1 = new admin();
			customer customer = new customer();
			catalog c1 = new catalog();
			System.out.println("--------------------------------------------");
			System.out.println("1- login");
			System.out.println("2- register");
			System.out.println("3- continue as guest");
			System.out.println("4- exit");
			System.out.println("--------------------------------------------");
			int choice = scan.nextInt();
			if(choice==1) {
				
				System.out.println("1- As Admin ");
				System.out.println("2- As Customer ");
				int choice2 = scan.nextInt();
				
				if(choice2==1) {
					a1.signIn();
				}
				else if(choice2==2) {
					customer.signIn();
				}
				
			}
			else if(choice==2) {
				System.out.println("1- As Admin ");
				System.out.println("2- As Customer ");
				int choice2 = scan.nextInt();
				
				if(choice2==1) {
					System.out.println("Choose A Username: ");
					String name = scan.next();
					System.out.println("Choose A Password: ");
					String password = scan.next();
					a1.signUp(name,password);
				}
				else if(choice2==2) {
					System.out.println("Choose A Username: ");
					String name = scan.next();
					System.out.println("Choose A Password: ");
					String password = scan.next();
					System.out.println("Enter your address: ");
					String address = scan.next();
					customer.signUp(name,password,address);
				}
				
			}
			else if(choice==3) {
				isGuest=true;
			}
			else if(choice ==4) {
				break;
			}
			
			while(a1.loggedIn==true) {
				System.out.println("--------------------------------------------");
				System.out.println("1- view");
				System.out.println("2- Add New Item");
				System.out.println("3- modify existing item");
			}
		}
		
	}
}
