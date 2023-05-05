package toffe;

public class item {
	private String name;
	private String category;
	private String description;
	private String brand;
	private double price;
	private double discount;
	private Integer itemId;
	private static Integer Id =0;       //used to set the item id
	public item(String name) {
		this.name = name;
	}
	public item(String name, String category, String brand, double price) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.brand = brand;
		this.setId(Id);
		Id++;
	}
	
	private void setName(String n) {
		this.name= n ;
	}
	private void setCategory(String n) {
		this.category= n ;
	}
	private void setdescription(String n) {
		this.description= n ;
	}
	private void setBrand(String b) {
		this.brand = b;
	}
	private void setPrice(float p) {
		this.price= p;
	}
	private void setDiscount(double d) {
		this.discount= d;
	}
	private void setId(int i) {
		this.itemId = i;
	}

	public String getName() {
		return this.name;
	}
	public String getCategory() {
		return this.category;
	}
	public String getDescription() {
		return this.description;
	}
	public String getBrand() {
		return this.brand;
	}
	public double getPrice() {
		return this.price;
	}
	public double getDiscount() {
		return this.discount;
	}
	public Integer getItemId() {
		return this.itemId;
	}
	@Override
    public String toString() {
		System.out.println("------------------------------------------------------");
        return "name: "+this.name + ", category: " + this.category +", describtion: "+this.description +" ,brand: "+this.brand+" ,price: "+this.price+
        		", discount: "+this.discount+ ", item id: "+this.itemId+"             ";
    }
	
}

