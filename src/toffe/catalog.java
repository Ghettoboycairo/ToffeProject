package toffe;

import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
	Integer index = 0;
	protected ArrayList <Category> categoryList = new ArrayList <Category>();   //array list of categories
	
	
	protected void viewAllCategories() {    //views all the categories stored in the list
		for(int i=0;i<categoryList.size();i++) {
			System.out.print(i+1+("- "));
			System.out.println( categoryList.get(i).getName());
		}
	}
	protected void viewAllItems() {        //views all the items stored in each and every Category
		for(int i=0;i<categoryList.size();i++) {
			categoryList.get(i).viewAllCategoryItems();
		}
	}
	protected void getItem(String name) {  //for searching for an Item by its name
		boolean itemFound = false;
		for(int i=0;i<categoryList.size();i++) {   // loops through each Category 
			for(int j=0;j<categoryList.get(i).itemList.size();j++) {  //loops through each Item 
				if(categoryList.get(i).itemList.get(j).getName().equalsIgnoreCase(name)) {   // if the Item name equal the name we gave the function:
					System.out.println(categoryList.get(i).itemList.get(j));        // get that Item
					itemFound = true;
				}
			}
		}
		if(itemFound ==true) {
			System.out.println("Done: Item found.");
		}
		else if(itemFound==false) {
			System.out.println("Couldn't Find Your Item.");
		}
		
	}
	protected Item getItem(int id) {
		boolean itemFound = false;
		Item theItem = null;
		for(int i=0;i<categoryList.size();i++) {   // loops through each Category 
			for(int j=0;j<categoryList.get(i).itemList.size();j++) {  //loops through each Item 
				if(categoryList.get(i).itemList.get(j).getItemId()==id) {   // if the Item name equal the name we gave the function:
					itemFound = true;
					theItem = categoryList.get(i).itemList.get(j);
					return theItem;
				}
			}
		}
		if(itemFound ==true) {
			System.out.println("Done: Item found.");
		}
		else if(itemFound==false) {
			System.out.println("Couldn't Find Your Item.");
		}
		return theItem;
	}

	protected void removeItem() {
		Scanner scan = new Scanner(System.in);
		String itemToBeRemoved = scan.next();
		for(int i=0;i<this.categoryList.size();i++) {        //first loop iterates around each Category available in the Catalog
			for(int j=0;j<this.categoryList.get(i).itemList.size();j++) {       //second loop iterates around each Item in the Category i
				String temp = this.categoryList.get(i).itemList.get(j).getName();  //temp equals Item j in the Category i
				if(temp.equals(itemToBeRemoved)) {   //remove the Item if Item j in Category i equals the Item we want to remove								
					this.categoryList.get(i).itemList.remove(j);
					System.out.println("Removed Item Successfully");
			
				}
			}
		}
	}
	
	
}

