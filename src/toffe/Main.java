package toffe;

import java.util.Scanner;


public class Main { 
	private static Boolean exit = false;
	private static Catalog catalog = new Catalog();
	private static CustomerManager customerManager = new CustomerManager(); 
	private static AdminManager adminManager = new AdminManager();				   
	
	
	public static void main(String[] args) {
		initializeSystem();
		Scanner scan = new Scanner(System.in); 
		
		while(exit!=true) {
			mainMenu();
			int choice = getUserInput();
			switch(choice) {
				case 1:            			//case 1 for login will check the hashmaps of the AdminManager or the CustomerManager
					handleLogin();            
					if(adminManager.loggedIn==true) {
						handleAdminMenu();
					}
					else if(customerManager.loggedIn==true) {
						handleCustomerMenu();
					}
					else {
						break;
					}
				case 2:     				//case 2 for registration 
					customerManager.signUp();
					break;
				case 3:                     //case 3 for viewing all the Catalog
					browseCatalog();
					break;
				case 4:                    	//case 4 for searching for an Item through the whole Catalog (all the categories) 
					System.out.println("Enter The Name Of The Item You Want To Search For: ");
					String name = scan.next();
					catalog.getItem(name);
					break;
				case 5:                     //case 5 for exiting the program
					exit=true;
					scan.close();
					break;
			}
		}		
	}
	private static void initializeSystem() {
        catalog = new Catalog();
        customerManager = new CustomerManager();
        adminManager = new AdminManager();
        createDummyData();
    }
	private static void mainMenu() {
		System.out.println("--------------------------------------------");    //first menu
		System.out.println("1- Login");
		System.out.println("2- Register");
		System.out.println("3- Browse The Catalog");
		System.out.println("4- Search For An Item");
		System.out.println("5- Exit");
		System.out.println("--------------------------------------------"); 
	}
	private static void adminMenu() {
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
		
	}
	private static void customerMenu() {
		System.out.println("1- View Catalog. ");
		System.out.println("2- View Previous Orders. ");
		System.out.println("3- View Cart. ");
		System.out.println("4- Checkout. ");
		System.out.println("5- LogOut. ");
	}
	private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
	private static void createDummyData() {
		Category toffe = new Category("Toffe",catalog);      //dummies (2 categories toffe and drinks, 2 items pepsi and jellycola for categories drinks and toffe)   
		Category drinks = new Category("Drinks",catalog);
		Item pepsi = new Item("pepsi", "drinks","cocaCola" , 6.5);
		Item jellyCola = new Item("jellyCola", "toffe","jellyColaInc" , 4);
		adminManager.addItemToCategory(drinks, pepsi);
		adminManager.addItemToCategory(toffe, jellyCola);
	}
	private static void handleLogin() {
        System.out.println("--------------------------------------------");
        System.out.println("1- Login as Admin");
        System.out.println("2- Login as Customer");
        System.out.println("--------------------------------------------");
        int choice = getUserInput();

        switch (choice) {
            case 1:
                adminManager.signIn();
                handleAdminMenu();
                break;
            case 2:
                customerManager.signIn();
                break;
            default:
                System.out.println("Enter a valid choice.");
                break;
        }
    }
	private static void handleAdminMenu() {
        while (adminManager.loggedIn==true) {
            adminMenu();
            int choice = getUserInput();
            switch (choice) {
                case 1:
                    catalog.viewAllCategories();
                    break;
                case 2:
                    adminManager.addNewItem(catalog);
                    break;
                case 3:
                	adminManager.addNewCategory(catalog);
                    break;
                case 4:
                    // Modify existing item
                    break;
                case 5:
                    adminManager.addNewItem(catalog);  // Add item to catalog
                    break;
                case 6:
                    catalog.viewAllItems();
                    catalog.removeItem();
                    break;
                case 7:
                    adminManager.signUp();
                    break;
                case 8:
                    adminManager.signOut();
                    break;
                default:
                    System.out.println("Enter a valid choice.");
                    break;
            }
        }
    }
	private static void handleCustomerMenu() {
		 while (customerManager.loggedIn==true) {
			 customerMenu();
	            int choice = getUserInput();
	            switch(choice) {
	            	case 1:                  //for viewing all the items then making an order by Item id
	            		System.out.println("1- View All The Items. ");
	            		System.out.println("2- View A Certain Category. ");
	            		int choice2 = getUserInput();
	            		if(choice2==1) {
	            			catalog.viewAllItems();
	            			System.out.println("------------------------------------------------------");
	            			System.out.println("Enter The Id Of The Item You Want To Add To Your Cart: ");
	            			int choice7 = getUserInput();
	            			CustomerManager.customerNameToCart.get(customerManager.userName).orderedItems.add(catalog.getItem(choice7));
	            		}
	            		else if(choice2==2) {
	            			System.out.println("Choose A Category: ");
	            			catalog.viewAllCategories();
	            			int choice3 = getUserInput();
	            			catalog.categoryList.get(choice3-1).viewAllCategoryItems();  //viewing all the items in a certain category
	            			System.out.println("Enter The Id Of The Item You Want To Add To Your Cart: ");
	            			int choice8 = getUserInput();
	            			CustomerManager.customerNameToCart.get(customerManager.userName).orderedItems.add(catalog.getItem(choice8)); //adding a new item to the cart by its id
	            		}
	            		
	            	case 2:
				
				
				
	            	case 3:
	            		System.out.println("This Is User "+customerManager.userName+" Cart Items: ");
	            		CustomerManager.customerNameToCart.get(customerManager.userName).displayItems();
	            		System.out.println("------------------------------------------------------");
	            	case 4:
				
	            	case 5:
	            		customerManager.signOut();
	            }
		 }       
	}
	private static void browseCatalog() {
		System.out.println("1- View All Items");
		System.out.println("2- View By Category");
		int choice4 = getUserInput();
		if(choice4==1) {
			catalog.viewAllItems();
		}
		else if (choice4==2) {
			catalog.viewAllCategories();
			System.out.println("Choose A Category To View:");
			int choice5 =  getUserInput();
			catalog.categoryList.get(choice5-1).viewAllCategoryItems();;
		}
	}

}




