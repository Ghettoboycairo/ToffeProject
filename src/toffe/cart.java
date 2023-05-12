package toffe;

import java.util.ArrayList;
import java.util.Scanner;

class Cart{
	protected ArrayList<Item> orderedItems;    //holds the items in the Cart
	protected ArrayList<Orders> previousOrders; //holds previous orders
	
	
	
	public Cart() {       //cart constructor will be called every time a new customer is registering
        orderedItems = new ArrayList<>();
    }
	public void addItem(Item Item) {
		orderedItems.add(Item);
    }
	public void removeItem(Item Item) {
    	orderedItems.remove(Item);
    }
	public void displayItems() {
        System.out.println("Available items:");
        for (int i = 0 ; i<orderedItems.size();i++) {
            System.out.println(orderedItems.get(i));
        }
    }
	public void displayPreviousOrders() {   //not working yet
		for(int i = 0 ;i < previousOrders.size(); i++) {
			System.out.println(previousOrders.get(i));
		}
	}
//	public void checkOut() {
//		displayItems();
//		System.out.println("Are You Sure You Want To Proceed With That Order? ");
//		System.out.println("");
//		Scanner scan = new Scanner(System.in);
//		
//		
//	}
	
}