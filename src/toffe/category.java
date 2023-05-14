/*Category class holds all the item assigned to it
 * Attributes:
 * 			name - the name of the category set with the constructor call
 * 			itemList - a list of all the items available in this list
 *Functions:
 *			Category - constructor takes a name and the catalog (we only have one unique catalog in this system)
 *			viewAllCategoryItems - views all the items stored in the list of this Category
 * 			getName - gets the name of this category
 */

package toffe;

import java.util.ArrayList;

public class Category {
	protected String name;
	protected ArrayList <Item> itemList = new ArrayList <Item>();
	
	public Category(String name, Catalog c) {
		this.name = name;
		c.categoryList.add(this);
	}
	
	protected void viewAllCategoryItems() {    
		for(int i=0;i<itemList.size();i++) {
			System.out.println(itemList.get(i));
		}
	}
	protected String getName() {
		return this.name;
	}


}
