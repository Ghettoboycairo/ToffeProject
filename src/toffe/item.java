package toffe;

public class item {
	private String name;
	private String category;
	private String description;
	private String brand;
	private double price;
	private double discount;
	private Integer itemId;
	private static Integer Id =0;
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
	
	private String setName(String n) {
		this.name= n ;
		return name;
	}
	private String setCategory(String n) {
		this.category= n ;
		return category;
	}
	private String setdescription(String n) {
		this.description= n ;
		return description;
	}
	private String setBrand(String b) {
		this.brand = b;
		return brand;
	}
	private double setPrice(float p) {
		this.price= p;
		return price;
	}
	private double setDiscount(double d) {
		this.discount= d;
		return discount;
	}
	private Integer setId(int i) {
		this.itemId = i;
		return itemId;
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
		return itemId;
	}
	@Override
    public String toString() {
        return "name: "+this.name + ", category: " + this.category +", describtion: "+this.description +" ,brand: "+this.brand+" ,price: "+this.price+
        		", discount: "+this.discount+ ", item id: "+this.itemId;
    }
	
}

