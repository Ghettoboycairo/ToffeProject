package toffe;

import java.util.Scanner;

public class controlClass {               //kind of like the main method.
	private static Boolean exit = false;
//	catalog c1 = new catalog();
//	admin a1 = new admin();
	
	
	public static void main(String[] args) {
		catalog c1 = new catalog();            //creating an instance of the class catalog and called it c1
		customer customers = new customer();
		admin a1 = new admin();				   //creating an instance of the admin class and called it a1
		category toffe = new category("toffe",c1);
		
		while(exit!=true) {
			if(a1.loggedIn==true) {
				System.out.println("-Admin is logged in");        //will be printed after you create an admin account and signIn with that account
			}
			System.out.println("--------------------------------------------");    //first menu
			System.out.println("1- Login");
			System.out.println("2- Register");
			System.out.println("3- View All The Catalog");
			System.out.println("4- Search For Item");
			System.out.println("5- Exit");
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
						while(a1.loggedIn==true) {  //if so it will change the admin class boolean logged in to true so the admin control menu will be shown
							System.out.println("--------------------------------------------");
							System.out.println("1- View All Categories. ");
							System.out.println("2- Add New Item. ");
							System.out.println("3- Add New Category. ");
							System.out.println("4- Modify Existing Item. ");
							System.out.println("5- Add Item To Catalog. ");
							System.out.println("6- Remove Item From Catalog. ");
							System.out.println("7- Add A New Admin Account. ");
							System.out.println("8- LogOut. ");
							System.out.println("--------------------------------------------");
							
							int choice3 = scan.nextInt();
							
							if(choice3==1) {          //prints out all categories
								c1.viewAllCategories();
//								System.out.println("Choose an option");
							}
							else if(choice3==2) {
								a1.addNewItem(c1);	 //adds a new item to the catalog
							}
							else if(choice3 ==3) {        //creates a new category and adds it to the catalog (arrayList cattegoryList) 
								System.out.println("Enter A Name For The Category You Want To Add: ");
								String categoryName = scan.next();
								new category(categoryName,c1);
							}
							else if(choice3==4) {
								
							}
							else if(choice3==5) {
								
							}
							else if(choice3==6) {     //removes item from the catalog
								c1.viewAllItems();
								System.out.println("---------------------------------------------");
								System.out.println("enter the name of the item you want to remove: ");
								String removeItem = scan.next();
								for(int i=0;i<c1.categoryList.size();i++) {        //first loop iterates around each category available in the catalog
									for(int j=0;j<c1.categoryList.get(i).itemList.size();j++) {       //second loop iterates around each item in the category i
										String temp = c1.categoryList.get(i).itemList.get(j).getName();  //temp equals item j in the category i
										if(temp.equals(removeItem)) {   //remove the item if item j in category i equals the item we want to remove								
											c1.categoryList.get(i).itemList.remove(j);
											System.out.println("Removed Item Successfully");
									
										}
									}
								}
							}
							else if(choice3 ==7) {
								a1.signUp();
							}
							else if(choice3 ==8) {   //changes the admin class loggedIn boolean to false which closes the admin menu 
								a1.signOut();
								break;
							}
							else{
								System.out.println("Enter A Valid Number. ");
							}
						}
					}
					break;
				
				case 2:                             //case 2 for registration 
					customers.signUp();
					break;
				
				case 3:                     //case 3 for viewing all the catalog
					c1.viewAllItems();    
					break;
				case 4: 
					
				case 5:                     //case 5 for exiting the program
					exit=true;
					scan.close();
					break;
			}
		}	
	}
}

