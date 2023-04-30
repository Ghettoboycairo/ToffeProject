package toffe;

import java.util.ArrayList;

public class catalog {
	Integer index = 0;
	protected ArrayList <item> itemList = new ArrayList <item>();   //array list of items (the actual catalog)
																	//might create more instances of this class to serve as different categories
	
	
	protected void viewAllItems() {    //views all the items stored in the list
		for(int i=0;i<itemList.size();i++) {
			viewItemInfo(itemList.get(i));
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
}

