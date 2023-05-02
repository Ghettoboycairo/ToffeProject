package toffe;

import java.util.ArrayList;

public class category {
	protected String name;
	protected ArrayList <item> itemList = new ArrayList <item>();
	
	public category(String name, catalog c) {
		this.name = name;
		c.categoryList.add(this);
	}
	
	protected void viewAllCategoryItems() {    //views all the items stored in the list of this category
		for(int i=0;i<itemList.size();i++) {
			System.out.println(itemList.get(i));
		}
	}
	protected String getName() {
		return this.name;
	}
	public static void main(String[] args) {
//		System.out.println("a7a");
//		catalog c1 = new catalog();
//		category drinks = new category("drinks",c1);
//		category sweets = new category("sweets",c1);
//		admin a1 = new admin();
//		item cola = new item("cola","drinks", "cocacola", 6);
//		item toffe = new item("toffe","sweets", "candyworld", 6);
//		a1.addItemToCategory(sweets, toffe);
//		a1.addItemToCategory(drinks, cola);
//		drinks.viewAllCategoryItems();
//		sweets.viewAllCategoryItems();
//		c1.viewAllCategories();
//		c1.viewAllItems();
	}

}
