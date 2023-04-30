package toffe;

import java.util.Scanner;

public class controlClass {               //kinda like the main method.
	private static Boolean exit = false;
	catalog c1 = new catalog();
	admin a1 = new admin();
	
	
	public static void main(String[] args) {
		catalog c1 = new catalog();            //creating an instance of the class catalog and called it c1
		admin a1 = new admin();				   //creating an instance of the admin class and called it a1
			
		while(exit!=true) {
			if(a1.loggedIn==true) {
				System.out.println("-Admin is logged in");        //will be printed after you create an admin account and signIn with that account
			}
			System.out.println("--------------------------------------------");    //first menu
			System.out.println("1- Login");
			System.out.println("2- Register");
			System.out.println("3- View Catalog");
			System.out.println("4- Exit");
			System.out.println("--------------------------------------------");                                                         
			String name = null;
			String password = null;
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch(choice) {
				case 1:                                   //case 1 for login will check the hashmaps of the admin or the customer
					System.out.println("--------------------------------------------");
					System.out.println("1- as admin");
					System.out.println("2- as a customer");
					System.out.println("--------------------------------------------");              
					int choice11 = scan.nextInt();
					if(choice11==1) {
						a1.signIn();                      //admin class method to check if the credentials given innit exist in the admin accounts hashmap
						while(a1.loggedIn==true) {		  //if so it will change the admin class boolean logged in to true so the admin control menu will be shown
							System.out.println("--------------------------------------------");
							System.out.println("1- View Catalog. ");
							System.out.println("2- Add New Item. ");
							System.out.println("3- Modify Existing Item. ");
							System.out.println("4- Add Item To Catalog. ");
							System.out.println("5- Remove Item From Catalog. ");
							System.out.println("6- LogOut. ");
							System.out.println("--------------------------------------------");
							
							int choice3 = scan.nextInt();
							
							if(choice3==1) {          //prints out all items
								c1.viewAllItems();
							}
							else if(choice3==2) {
								a1.addNewItem(c1);	 //adds a new item to the catalog
							}
							else if(choice ==3) {
								
							}
							else if(choice==4) {
								
							}
							else if(choice3==5) {     //removes item from the catalog
								c1.viewAllItems();
								System.out.println("enter the name of the item you want to remove: ");
								String remove = scan.nextLine();
								c1.itemList.remove(remove);
							}
							else if(choice ==6) {   //changes the admin class loggedIn boolean to false which closes the admin menu 
								a1.signOut();
								break;
							}else{
								System.out.println("Enter A Valid Number. ");
							}
						}
					}
					break;
				case 2:                             //case 2 for registration 
					System.out.println("--------------------------------------------");  
					System.out.println("1- as admin");             // signUp as an admin or as a customer
					System.out.println("2- as a customer");
					System.out.println("--------------------------------------------"); 
					int choice2= scan.nextInt();
					if(choice2==1) {
						System.out.println("choose a username: ");
						name = scan.next();
						System.out.println("choose a password: ");
						password = scan.next();
						a1.signUp(name,password);  // adds the chosen new account credentials to the admin class hashmap
					}
					break;
				case 3:
					c1.viewAllItems();      //case 3 for viewing all the catalog
				case 4:                     //case 4 for exiting the program
					exit=true;
					scan.close();
					break;
			}
		}	
	}
}

