the toffe system serves as an e-commerce system and implements the following features and a few more:

-viewing the catalog or searching for an item before logging in.

-registering a customer and login.

-displaying a catalog of items loaded from inside the system and an admin can add more items and categories.

-shopping for items and adding them to cart, and making an order to be paid upon delivery in cash.

-The following are describtions describing some of the attributes and functions for most of the functions:


- Main:

  Class serves as the entry point for the system.

  Attributes:
    - exit: When true, it terminates the program.
    - catalog: Static because it doesn't need to be altered.
    - customerManager: Static because the system needs one instance to manage all the customers.
    - adminManager: Static because the system needs one instance to manage all the admins.

  Functions:
    - initializeSystem: Initializes classes (catalog, customerManager, adminManager) and creates a few dummy data such as items and categories.
    - handleLogin: Handles the login process for both the admins and the customers.
    - handleAdminMenu: Views the admin menu and functionalities if an admin is logged in.
    - handleCustomerMenu: Views the customer menu and functionalities if a customer is logged in.

- AdminManager:

  Serves as a manager for all the admin accounts and holds the data structures related to the admins. The default admin credentials are (admin, admin).

  Attributes:
    - loggedIn: Indicates if an admin is logged in.
    - adminLog: Hashmap where the key is the admin name and the value is the admin password.

  Functions:
    - AdminManager: The constructor sets the default admin credentials (admin, admin).
    - signUp: Adds the new account credentials to the hashmap.
    - signIn: Checks if the given credentials exist in the hashmap and, if so, changes the loggedIn boolean to true.
    - addItemToCategory: Takes a category and an item and adds the item to the category.
    - addNewItem: Creates a new item and adds it to the chosen category.
    - addNewCategory: Adds a new category to the system.
    - signOut: Changes the loggedIn boolean to false.

- Cart:

  Class works as a vessel for the items of each customer. Each sign up in the CustomerManager class creates a new cart and adds it to the new customer.

  Functions:
    - addItem: Adds an item to the cart.
    - removeItem: Removes an item from the cart.
    - displayItems: Displays all the items in the cart.

- Catalog:

  Serves as a list for the categories.

  Attributes:
    - categoryList: A list of categories.

  Functions:
    - viewAllCategories: Views all the categories stored in the list.
    - viewAllItems: Views all the items stored in each category.
    - getItem: Searches for an item by its name.
    - removeItemById: Removes an item by its ID. (Overloaded version gets an item by its ID.)

- Category:

  Class holds all the items assigned to it.

  Attributes:
    - name: The name of the category set with the constructor call.
    - itemList: A list of all the items available in this category.

  Functions:
    - Category: Constructor takes a name and the catalog (we only have one unique catalog in this system).
    - viewAllCategoryItems: Views all the items stored in the list of this category.
    - getName: Gets the name of this category.

- CustomerManager:

  Holds all the customer-related data and manages sign up, sign out, and login of each customer.

  Attributes:
    - customerNameToAddressLog: Hashmap with the key as the username and the value as the address.
    - customerNameToPasswordLog: Hashmap with the key as the username and the value as the user password.
    - customerNameToEmail: Hashmap with the key as the username and the value as the user email.
    - customerNameToCartLog: Hashmap with the key as the username and the value as a unique object of type
cart.
    - customerNameToPasswordLog: Hashmap with the key as the username and the value as an ArrayList that holds objects of type orders.
    - userName: Holds the name of the customer and is set when the signIn function is called. It is set to null when signOut is called.
    - loggedIn: Indicates if a customer is logged in.

  Functions:
    - signUp: Asks the user for the data required to sign them up and assigns the data to the corresponding data structures if the username entered doesn't already exist.
    - signIn: Signs the user in if the username exists in the logs and the entered password is correct. If so, it assigns the username to the userName attribute and changes the loggedIn boolean to true to indicate that a user is logged in.
    - signOut: Sets the userName to null and loggedIn to false.

- Order:

  Class serves as an order for every time a user checks out with a cart.

  Attributes:
    - allOrders: Holds all the previous orders made by each customer.
    - deliveryAddress: Holds the address of the customer who made the order.
    - itemList: Holds the items of the cart.

  Functions:
    - Order: The constructor creates a new ArrayList of itemList and adds to it all the cart items. It adds the order to the allOrders list and the customerNameToPreviousOrders to be saved as the customer's order history. Finally, it clears the customer's cart as it is now an active order.
    - viewAllOrders: Views all the orders of all the customers.    
