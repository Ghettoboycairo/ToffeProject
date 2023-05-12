package toffe;

import java.util.ArrayList;

public class Order {
	protected static ArrayList<Order> allOrders = new ArrayList<>(); //to hold all the orders
	String orderedBy;     //holds the name of the customer
	String deliveryAddress;  //holds the address of the customer
	ArrayList<Item> itemList;   //holds the content of the cart
	
	Order(CustomerManager customer) {
		orderedBy = customer.userName;
		deliveryAddress = customer.customerNameToAddressLog.get(orderedBy);
		itemList = customer.customerNameToCart.get(orderedBy).orderedItems;
        CustomerManager.customerNameToPreviousOrders.get(customer.userName).add(this);    //assigns this order to the customer arrayList of orders
        allOrders.add(this);          //adds this order to the static array list of all the orders
        customer.customerNameToCart.get(orderedBy).orderedItems.clear();;
	}
	protected void viewAllOrders() {
		for(int i = 0;i<allOrders.size();i++) {
			System.out.println("Order Number "+(i+1));
			System.out.println(allOrders.get(i));
		}
		System.out.println("No More Orders To View...");
	}
	
	
	public String toString() {
		System.out.println("------------------------------------------------------");
		System.out.println("This Order Was Made By Customer: "+this.orderedBy);
		System.out.println("And His Address Is "+deliveryAddress);
		System.out.println("The Order Contains The Following Items: ");
		for(int i=0;i<itemList.size();i++) {
			System.out.println(itemList.get(i));
			
		}
		return"-----------------------------------";
	}
	

}
