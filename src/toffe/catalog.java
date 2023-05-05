package toffe;

import java.util.ArrayList;

public class catalog {
	Integer index = 0;
	protected ArrayList <category> categoryList = new ArrayList <category>();   //array list of categories
	
	
	protected void viewAllCategories() {    //views all the categories stored in the list
		for(int i=0;i<categoryList.size();i++) {
			System.out.print(i+1+("- "));
			System.out.println( categoryList.get(i).getName());
		}
	}
	protected void viewAllItems() {        //views all the items stored in each and every category
		for(int i=0;i<categoryList.size();i++) {
			categoryList.get(i).viewAllCategoryItems();
		}
	}
	protected void getItem(String name) {  //for searching for an item by its name
		boolean itemFound = false;
		for(int i=0;i<categoryList.size();i++) {   // loops through each category 
			for(int j=0;j<categoryList.get(i).itemList.size();j++) {  //loops through each item 
				if(categoryList.get(i).itemList.get(j).getName().equalsIgnoreCase(name)) {   // if the item name equal the name we gave the function:
					System.out.println(categoryList.get(i).itemList.get(j));        // get that item
					itemFound = true;
				}
			}
		}
		if(itemFound ==true) {
			System.out.println("Done: item found.");
		}
		else if(itemFound==false) {
			System.out.println("Couldn't Find Your Item.");
		}
		
	}
//	protected void viewCategoryItems(category c) {                //views certain item info
//		System.out.println(x.getName());
//		System.out.println(x.getCategory());
//		System.out.println(x.getDescription());
//		System.out.println(x.getBrand());
//		System.out.println(x.getPrice());
//		System.out.println(x.getDiscount());
//		System.out.println(x.getItemId());
//		System.out.println("____________________");
//		
//	}
}

