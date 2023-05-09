package toffe;

import java.util.Scanner;

public class Main {               //kind of like the main method.
	private static Boolean exit = false;
//	catalog c1 = new catalog();
//	admin a1 = new admin();
	
	
	public static void main(String[] args) {
		catalog c1 = new catalog();            //creating an instance of the class catalog and called it c1
		customer customers = new customer();   //creating an instance of the customers class
		admin a1 = new admin();				   //creating an instance of the admin class and called it a1
		
		category toffe = new category("Toffe",c1);      //dummies (2 categories toffe and drinks, 2 items pepsi and jellycola for categories drinks and toffe)   
		category drinks = new category("Drinks",c1);
		item pepsi = new item("pepsi", "drinks","cocaCola" , 6.5);
		item jellyCola = new item("jellyCola", "toffe","jellyColaInc" , 4);
		a1.addItemToCategory(drinks, pepsi);
		a1.addItemToCategory(toffe, jellyCola);
		
		while(exit!=true) {
			System.out.println("--------------------------------------------");    //first menu
			System.out.println("1- Login");
			System.out.println("2- Register");
			System.out.println("3- Browse The Catalog");
			System.out.println("4- Search For An Item");
			System.out.println("5- Exit");
			System.out.println("--------------------------------------------");                                                         
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
			switch(choice) {
				
				case 1:                                   //case 1 for login will check the hashmaps of the admin or the customer
					System.out.println("--------------------------------------------");
					System.out.println("1- as admin");
					System.out.println("2- as a customer");
					System.out.println("--------------------------------------------");              
					int choice11 = scan.nextInt();
					if(choice11==1) {    //choice 1 for login as admin
						a1.signIn();             //admin class method to check if the credentials given innit exist in the admin accounts hashmap
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
///								System.out.println("Choose an option");
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
					else if(choice11==2) { //choice 2 for login as a customer
						
					}
					break;
				
				case 2:                             //case 2 for registration 
					customers.signUp();
					break;
				
				case 3:                     //case 3 for viewing all the catalog
					System.out.println("1- View All Items");
					System.out.println("2- View By Category");
					int choice4 = scan.nextInt();
					if(choice4==1) {
						c1.viewAllItems();
					}
					else if (choice4==2) {
						c1.viewAllCategories();
						System.out.println("Choose A Category To View:");
						int choice5 =  scan.nextInt();
						c1.categoryList.get(choice5-1).viewAllCategoryItems();;
					}
					break;
					
				case 4:                    //case 4 for searching for an item through the whole catalog (all the categories) 
					System.out.println("Enter The Name Of The Item You Want To Search For: ");
					String name = scan.next();
					c1.getItem(name);
					break;
					
				case 5:                     //case 5 for exiting the program
					exit=true;
					scan.close();
					break;
			}
		}	
	}
}

