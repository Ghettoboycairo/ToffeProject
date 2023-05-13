package toffe;

import java.util.ArrayList;
//import java.util.Scanner;

class Cart{
	protected ArrayList<Item> orderedItems;    //holds the items in the Cart
//	private String cartOwner;                //holds the name of the cart owner
	
	
	public Cart(String name) {       //cart constructor will be called every time a new customer is registering
//		this.cartOwner=name;
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

	
//	public void displayPreviousOrders() {   //not working yet
//		for(int i = 0 ;i < previousOrders.size(); i++) {
//			System.out.println(previousOrders.get(i));
//		}
//	}
//	public void checkOut() {
//		displayItems();
//		System.out.println("Are You Sure You Want To Proceed With That Order? ");
//		System.out.println("");
//		Scanner scan = new Scanner(System.in);
//		
//		
//	}
	
}