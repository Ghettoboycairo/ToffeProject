/*cart class works as a vessel for the items of each customer
 * as with each sign up in the CustomerManager class a new cart is made and added to the new customer
 * Functions:
 * 			addItem - adds an item to the cart
 * 			removeItem - removes an item from the cart
 * 			displayItems - displays all the items in the cart
*/

package toffe;

import java.util.ArrayList;

class Cart{
	protected ArrayList<Item> orderedItems;    //holds the items in the Cart
	
	public Cart(String name) {       //cart constructor will be called every time a new customer is registering
		this.orderedItems = new ArrayList<>();
    }
	
	public void addItem(Item Item) {
		this.orderedItems.add(Item);
    }
	public void removeItem(Item Item) {
    	orderedItems.remove(Item);
    }
	public void displayItems() {
		if(!orderedItems.isEmpty()) {
        	System.out.println("Available items:");
        	for (int i = 0 ; i<orderedItems.size();i++) {
        		System.out.println(orderedItems.get(i));
        	}
		}
		else {
			System.out.println("Cart is Empty..");
		}
    }
}