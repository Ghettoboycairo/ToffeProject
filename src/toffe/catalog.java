package toffe;

import java.util.ArrayList;

public class catalog {
	Integer index = 0;
	protected ArrayList <item> itemList = new ArrayList <item>();
	
	
	protected void viewAllItems() {    //views all the items stored in the list
		while(index<itemList.size()) {
			System.out.println("____________________");
			viewItemInfo(itemList.get(index));
			index+=1;
		}
	}
	protected void viewItemInfo(item x) {                //views certain item info
		System.out.println(x.getName());
		System.out.println(x.getCategory());
		System.out.println(x.getDescription());
		System.out.println(x.getBrand());
		System.out.println(x.getPrice());
		System.out.println(x.getDiscount());
		System.out.println(x.getItemId());
		System.out.println("____________________");
		
	}
	
	public void menu1() {                               //login,register,continue as guest
		System.out.println("--------------------------------------------");
		System.out.println("1- login");
		System.out.println("2- register");
		System.out.println("3- continue as guest");
		System.out.println("4- exit");
		System.out.println("--------------------------------------------");
	}
	public void menu2() {                               //login -> as admin, as customer
		System.out.println("--------------------------------------------");
		System.out.println("1- as admin");
		System.out.println("2- as a customer");
		System.out.println("--------------------------------------------");
	}
	public void menu3() {
		System.out.println("--------------------------------------------");
		System.out.println("1- view");
		System.out.println("2- delete existing item");
		System.out.println("3- modify existing item");
		System.out.println();
		System.out.println();
	}
}
