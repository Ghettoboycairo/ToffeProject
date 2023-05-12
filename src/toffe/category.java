package toffe;

import java.util.ArrayList;

public class Category {
	protected String name;
	protected ArrayList <Item> itemList = new ArrayList <Item>();
	
	public Category(String name, Catalog c) {
		this.name = name;
		c.categoryList.add(this);
	}
	
	protected void viewAllCategoryItems() {    //views all the items stored in the list of this Category
		for(int i=0;i<itemList.size();i++) {
			System.out.println(itemList.get(i));
		}
	}
	protected String getName() {
		return this.name;
	}


}
