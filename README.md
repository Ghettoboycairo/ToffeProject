the toffe system serves as an e-commerce system and implements the following features and a few more:

-viewing the catalog or searching for an item before logging in.

-registering a customer and login.

-displaying a catalog of items loaded from inside the system and an admin can add more items and categories.

-shopping for items and adding them to cart, and making an order to be paid upon delivery in cash.

-The following are describtions describing some of the attributes and functions for most of the functions:

-Main:

class serves as the entry point for the system.

        Atributes:
  			exit - when true it terminates the program
  			catalog - static because it dont need to be altered
  			customerManager - static because the system needs one instance to manage all the customers
  			adminManager - static because the system needs one instance to manage all the admins
        Functions:						
 			initializeSystem - initializes classes (catalog, customerManager, adminManager) and creates a few dummy data such as items and categories
 			handleLogin - handles the login process for both the admins and the customers
 			handleAdminMenu - views the admin menu and functionalities if a admin is logged in
 			handleCustomerMenu - views the customer menu and functionalities if a customer is logged in

-AdminManager:

serves as a manager for all the admin accounts and holds the data structures related to the admin the default admin credentials is (admin,admin)

    Attributes:
 			loggedIn - to indicate if an admin is logged in
  		adminLog - hashmap its key is the admin name and value is the admin password
    Functions:
 			AdminManager - the constructor puts the default admin credentials (admin,admin)
 			signUp - adds the new account credentials to the hashMap
 			signIn - checks if the given credentials exist in the hashMap and if so it changes the loggedIn boolean to true
 			addItemToCategory - takes a category and an item and adds the item to the category
  		addNewItem - creates a new item and adds it to the chosen category
 			addNewCategory - adds a new category to the system
 			signOut - changes the boolean loggenIn to false
      
-cart:

class works as a vessel for the items of each customer as with each sign up in the CustomerManager class a new cart is made and added to the new customer
    Functions:
      addItem - adds an item to the cart
    	removeItem - removes an item from the cart
  		displayItems - displays all the items in the cart

-Catalog:

serves as a list for the categories 
    Attributes:
  		categoryList - is a list of categories
    Functions:			
   		viewAllCategories - views all the categories stored in the list
 			viewAllItems - views all the items stored in each and every Category
 			getItem - for searching for an Item by its name
 			removeItemById - for removing an Item by its Id and the overloaded version gets an item by its Id
    
-Category:
class holds all the item assigned to it
    Attributes:
   		name - the name of the category set with the constructor call
 			itemList - a list of all the items available in this list
    Functions:
 			Category - constructor takes a name and the catalog (we only have one unique catalog in this system)
 			viewAllCategoryItems - views all the items stored in the list of this Category
 			getName - gets the name of this category

-CustomerManager:
holds all the customer related data and manages sign up sign out and login of each customer
     Attributes:
 			customerNameToAddressLog - is a hashmap with its key as the username and its value is the address
 			customerNameToPasswordLog - is a hashmap with its key as the username and its value is the user password
 			customerNameToEmail - is a hashmap with its key as the username and its value is the user email
 			customerNameToCartLog - is a hashmap with its key as the username and its value is a unique object of type cart
 			customerNameToPasswordLog - is a hashmap with its key as the username and its value is a arraylist that holds objects of type orders
 			userName - holds the name of the customer and is set when signIn function is called and set to null when signOut is called
 			loggedIn - to indicate if a customer is logged in 
     Functions:
 		   - signUp - asks the user for the data required to sign him up and assigns the data to the corresponding data structures if the username entered dont already exist
 		   - signIn - signs the user in if the userName exist in the logs and the entered password is correct, if so it assigns the username to the
          userName attribute and changes the boolean logged in to true to indicate that a user is logged in.
   		 - sigOut - sets the userName to null and loggedIn to false.



-Order:
class serves as an order for every time a user checks out with a cart
    Attributes:
 			allOrders - holds all the previous orders made by each and every customer
 			delieveryAddress - holds the address of the customer who made the order
 			itemList - holds the items of the cart 
    Functions:
 			Order - the constructor creates a new arraylist of itemList and adds to it all the cart items and adds the order to the allOrders list
 			and adds the order to the customerNameToPreviousOrders to be saved as the customer orders history
 			and clears the customer cart as its now an active order 			
 			viewAllOrders - views all the orders of all the customers
 
