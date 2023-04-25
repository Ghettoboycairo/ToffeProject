package toffe;

import java.util.Scanner;

public class controlClass {               //kinda like the main method.
	private static Boolean exit = false;
	catalog c1 = new catalog();
	admin a1 = new admin();
	
	
	public static void main(String[] args) {
		catalog c1 = new catalog();
		admin a1 = new admin();
			
		while(exit!=true) {
			if(a1.loggedIn==true) {
				System.out.println("-Admin is logged in");
			}
			System.out.println("--------------------------------------------");
			System.out.println("1- login");
			System.out.println("2- register");
			System.out.println("3- continue as guest");
			System.out.println("4- exit");
			System.out.println("--------------------------------------------");                                                         
			String name = null;
			String password = null;
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch(choice) {
				case 1:
					System.out.println("--------------------------------------------");
					System.out.println("1- as admin");
					System.out.println("2- as a customer");
					System.out.println("--------------------------------------------");              
					int choice11 = scan.nextInt();
					if(choice11==1) {
						a1.signIn();
						while(a1.loggedIn==true) {
							System.out.println("--------------------------------------------");
							System.out.println("1- View Catalog. ");
							System.out.println("2- Add New Item. ");
							System.out.println("3- Modify Existing Item. ");
							System.out.println("4- Add Item To Catalog. ");
							System.out.println("5- Remove Item From Catalog. ");
							System.out.println("--------------------------------------------");
							
							int choice3 = scan.nextInt();
							
							if(choice3==1) {
								c1.viewAllItems();
							}
							else if(choice3==2) {
								a1.addNewItem(c1);	
							}
							else if(choice ==3) {
								
							}
							else if(choice==4) {
								
							}
							else if(choice3==5) {
								c1.viewAllItems();
								System.out.println("enter the name of the item you want to remove: ");
								String remove = scan.nextLine();
								c1.itemList.remove(remove);
							}
							else if(choice ==6) {
								a1.signOut();
								break;
							}else{
								System.out.println("Enter A Valid Number. ");
							}
						}
					}
					break;
				case 2:
					System.out.println("--------------------------------------------");
					System.out.println("1- as admin");
					System.out.println("2- as a customer");
					System.out.println("--------------------------------------------"); 					                                 //1.as admin 2.as customer
					int choice2= scan.nextInt();
					if(choice2==1) {
						System.out.println("choose a username: ");
						name = scan.next();
						System.out.println("choose a password: ");
						password = scan.next();
						a1.signUp(name,password);
					}
					break;
				case 4:
					exit=true;
					scan.close();
					break;
			}
		}	
	}
}



//item toffe = new item("toffe","sweets","juhayna",12.5);
//item cola = new item("cola","drinks","cola",6);
//item pepsi = new item("pepsi","drinks","cola",6);
//
//catalog c1 = new catalog();
//admin a1 = new admin("admin","admin");
//a1.addItemToCatalog(c1, toffe);
//a1.addItemToCatalog(c1, cola);
//a1.addItemToCatalog(c1, pepsi);
//
////c1.viewItemInfo(pepsi);
////c1.viewItemInfo(toffe);
////c1.viewItemInfo(cola);
//
//c1.viewAllItems(c1.itemList);
