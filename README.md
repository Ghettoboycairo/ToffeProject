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
