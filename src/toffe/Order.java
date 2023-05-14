/*Order to serve as an order for every time a user checks out with a cart
 * Attributes:
 * 			allOrders - holds all the previous orders made by each and every customer
 * 			delieveryAddress - holds the address of the customer who made the order
 * 			itemList - holds the items of the cart 
 * Functions:
 * 			Order - the constructor creates a new arraylist of itemList and adds to it all the cart items and adds the order to the allOrders list
 * 			and adds the order to the customerNameToPreviousOrders to be saved as the customer orders history
 * 			and clears the customer cart as its now an active order
 * 			
 * 			viewAllOrders - views all the orders of all the customers			
 * 
 */
package toffe;

import java.util.ArrayList;

public class Order {
	protected static ArrayList<Order> allOrders = new ArrayList<>(); //to hold all the orders
	String orderedBy;                                                //holds the name of the customer
	String deliveryAddress;                                          //holds the address of the customer
	ArrayList<Item> itemList;                                        //holds the content of the cart
	
	Order(CustomerManager customer) {
		itemList = new ArrayList<>();
		orderedBy = customer.userName;
		deliveryAddress = CustomerManager.customerNameToAddressLog.get(orderedBy);
		itemList.addAll(CustomerManager.customerNameToCart.get(orderedBy).orderedItems);
        CustomerManager.customerNameToPreviousOrders.get(orderedBy).add(this);    //assigns this order to the customer arrayList of orders
        allOrders.add(this);                                                              //adds this order to the static array list of all the orders
        CustomerManager.customerNameToCart.get(orderedBy).orderedItems.clear();;
	}
	protected static void viewAllOrders() {
		for(int i = 0;i<allOrders.size();i++) {
			System.out.println("Order Number "+(i+1));
			System.out.println(allOrders.get(i));
//			for(int j=0;j<allOrders.get(i).itemList.size();j++) {
//				System.out.println("Item "+(j+1));
//				System.out.println(allOrders.get(i).itemList.get(j));
//			}
		}
		System.out.println("No More Orders To View...");
	}
	public String toString() {
		System.out.println("------------------------------------------------------");
		System.out.println("This Order Was Made By Customer: "+this.orderedBy);
		System.out.println("And His Address Is "+deliveryAddress);
		System.out.println("The Order Contains The Following Items: ");
		for(int i=0;i<itemList.size();i++) {
			System.out.println("///////////////////");
			System.out.println("Item Number: "+i+" ////");
			System.out.println("///////////////////");
			System.out.println(itemList.get(i));
		}
		return"-----------------------------------";
	}
}
