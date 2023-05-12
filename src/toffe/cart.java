package toffe;

import java.util.ArrayList;

class Cart{
	protected ArrayList<Item> orderedItems;    //holds the items in the Cart
	protected ArrayList<Orders> previousOrders; //holds previous orders
	
	
	
	public Cart() {
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
	public void displayPreviousOrders() {
		for(int i = 0 ;i < previousOrders.size(); i++) {
			System.out.println(previousOrders.get(i));
		}
	}
	public void checkOut() {
		displayItems();
		
	}
	
}