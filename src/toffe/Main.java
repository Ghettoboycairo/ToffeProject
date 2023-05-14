/*Main class serves as the entry point for the system
 * Atributes:
 * 			exit - when true it terminates the program
 * 			catalog - static because it dont need to be altered
 * 			customerManager - static because the system needs one instance to manage all the customers
 * 			adminManager - static because the system needs one instance to manage all the admins
 * Functions:						
 *			initializeSystem - initializes classes (catalog, customerManager, adminManager) and creates a few dummy data such as items and categories
 *			handleLogin - handles the login process for both the admins and the customers
 *			handleAdminMenu - views the admin menu and functionalities if a admin is logged in
 *			handleCustomerMenu - views the customer menu and functionalities if a customer is logged in
 */


package toffe;

import java.util.Scanner;


public class Main { 
	private static Boolean exit = false;
	private static Catalog catalog = new Catalog();
	private static CustomerManager customerManager = new CustomerManager(); 
	private static AdminManager adminManager = new AdminManager();				   
//	private Order order = new Order(customerManager);
	
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
					break;
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
				default:
					System.out.println("Invalid Choice.");
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
		System.out.println("8- View All Orders. ");
		System.out.println("9- LogOut. ");
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
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
	private static void createDummyData() {
		Category Toffe = new Category("Toffe",catalog);      //dummies (2 categories toffe and drinks, 2 items pepsi and jellycola for categories drinks and toffe)   
		Category Drinks = new Category("Drinks",catalog);
		Item pepsi = new Item("pepsi", "Drinks","cocaCola" , 6.5);
		Item jellyCola = new Item("jellyCola", "Toffe","jellyColaInc" , 4);
		Item toffe = new Item("toffe", "Toffe","ToffeMiddleEastInc" , 40);
		adminManager.addItemToCategory(Drinks, pepsi);
		adminManager.addItemToCategory(Toffe, jellyCola);
		adminManager.addItemToCategory(Toffe, toffe);
	}
	private static void handleLogin() {    //handling login for either the customer or the admin  (the default admin account credentials are (admin,admin) more admin accounts can be created from the admin menu 
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
	private static void handleAdminMenu() {   //for viewing and handling the admin control menu (will operate only if an admin is logged in)
        while (adminManager.loggedIn==true) {
            adminMenu();
            int choice = getUserInput();
            switch (choice) {
                case 1:                          //for viewing all the categories
                    catalog.viewAllCategories();
                    break;
                case 2:                          //for adding a new item
                    adminManager.addNewItem(catalog); 
                    break;
                case 3:                          //for adding a new category 
                	adminManager.addNewCategory(catalog); 
                    break;
                case 4:                         //for modifying item
                    modifyItem();
                    break;
                case 5:							// Add item to catalog
                    adminManager.addNewItem(catalog);  
                    break;
                case 6:                         //for removing item
                    catalog.viewAllItems();
                    catalog.removeItemById();
                    break;
                case 7:						    //for adding new admin account
                    adminManager.signUp();   
                    break;
                case 8:                         //for viewing all orders
                	Order.viewAllOrders();
                	break;
                case 9:							//for exiting the addmin menu
                    adminManager.signOut();  
                    break;
                default:
                    System.out.println("Enter a valid choice.");
                    break;
            }
        }
    }
	private static void handleCustomerMenu() {    //for viewing and handling the customer control menu (will operate only if a customer is logged in)
	    while (customerManager.loggedIn != false) {
	        customerMenu();
	        int choice = getUserInput();
	        switch (choice) {
	            case 1:                                      // for viewing the catalog two options are available
	                System.out.println("1- View All The Items. ");
	                System.out.println("2- View A Certain Category. ");
	                int choice2 = getUserInput();
	                if (choice2 == 1) {						// for viewing all the items then making an order by Item id
	               		catalog.viewAllItems();
	                   	System.out.println("------------------------------------------------------");
	                   	System.out.println("Enter 007 When You Finish Ordering..");
	                   	boolean exit = false;
	                   	while(exit!=true) {
	                   		System.out.println("Enter The Id Of The Item You Want To Add To Your Cart: ");
	                   		int choice7 = getUserInput();
	                   		if(choice7==007) {
	                   			exit=true;
	                   			break;
	                   		}
	                   		else{
	                   			CustomerManager.customerNameToCart.get(customerManager.userName).orderedItems.add(catalog.getItem(choice7));               
	                   		}
	                   	}
	                } 
	                else if (choice2 == 2) {				 // for viewing all the items by category then making an order by Item id
	                    System.out.println("Choose A Category: ");
	                    catalog.viewAllCategories();
	                    int choice3 = getUserInput();
	                    catalog.categoryList.get(choice3 - 1).viewAllCategoryItems(); // viewing all the items in a certain category
	                	boolean exit = false;
	                	System.out.println("Enter 007 When You Finish Ordering..");
	                   	while(exit!=true) {
	                   		System.out.println("Enter The Id Of The Item You Want To Add To Your Cart: ");
	                    	int choice8 = getUserInput();
	                    	if(choice8==007) {
	                    		exit=true;
	                    		break;
	                    	}
	                    	else {
	                    		CustomerManager.customerNameToCart.get(customerManager.userName).orderedItems.add(catalog.getItem(choice8)); // adding a new item to the cart by its id
	                    	}
	                   	}	
	                }
	                break;
	            case 2:            //for viewing the previous order
	            	for(int i=0 ; i<CustomerManager.customerNameToPreviousOrders.get(customerManager.userName).size();i++) {
	            		System.out.println(CustomerManager.customerNameToPreviousOrders.get(customerManager.userName).get(i));
	            	}
	                break;
	            case 3:				//for viewing the current customer cart
	            	if(!CustomerManager.customerNameToCart.get(customerManager.userName).orderedItems.isEmpty()) {
	            		System.out.println("This Is User " + customerManager.userName + " Cart Items: ");
	                	CustomerManager.customerNameToCart.get(customerManager.userName).displayItems();
	                	System.out.println("------------------------------------------------------");
	            	}
	            	else{
	            		System.out.println("The Cart Is Empty..");
	            	}
	                break;
	            case 4:				//for checking out
	            	new Order(customerManager);
	                break;
	            case 5:            //for signing out and terminating the customer menu
	                customerManager.signOut();
	                customerManager.loggedIn = false;
	                break;
	        }
	    }
	}
	private static void browseCatalog() {     //two different ways of viewing the catalog (will add a search option later)
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
		else {
			System.out.println("Enter A Valid Choice");
		}
	}
	private static void modifyItem() {     //a function made for the admin to view all the items, choosing an item to modify and changing item's attributes 
	    catalog.viewAllItems();
	    System.out.println("----------------------------------------------");
	    System.out.println("Enter The Id Of The Item You Want To Modify");
	    int itemId = getUserInput();
	    boolean exit = false;
	    while (exit == false) {
	        System.out.println("1- Modify Name.");
	        System.out.println("2- Modify Category.");
	        System.out.println("3- Modify Description.");
	        System.out.println("4- Modify Brand.");
	        System.out.println("5- Modify Discount.");
	        System.out.println("6- Modify Price.");
	        System.out.println("7- Exit.");
	        System.out.println("-----------------------------");
	        int choice1 = getUserInput();
	        switch (choice1) {
	            case 1:
	                catalog.getItem(itemId).setName();
	                break;
	            case 2:
	                catalog.getItem(itemId).setCategory();
	                break;
	            case 3:
	                catalog.getItem(itemId).setDescription();
	                break;
	            case 4:
	                catalog.getItem(itemId).setBrand();
	                break;
	            case 5:
	                catalog.getItem(itemId).setDiscount(getUserInput());
	                break;
	            case 6:
	            	catalog.getItem(itemId).setPrice();
	            case 7:
	                exit = true;
	                break;
	            default:
	                System.out.println("Enter a valid choice.");
	                break;
	        }
	    }
	}
}




