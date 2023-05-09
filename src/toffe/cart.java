import java.util.ArrayList;
import java.util.Scanner;

package toffe;

public class ShoppingShippingSystem {
    private ArrayList<Item> items;
    private ArrayList<Order> orders;

    public ShoppingShippingSystem() {
        items = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void displayItems() {
        System.out.println("Available items:");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void shipOrder(int id) {
        Order order = findOrderById(id);
        if (order == null) {
            System.out.println("Order not found");
        } else if (order.isShipped()) {
            System.out.println("Order already shipped");
        } else {
            order.ship();
            System.out.println("Order shipped");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingShippingSystem system = new ShoppingShippingSystem();

        // Add some products to the system
        Item item1 = new Item("cocacola", 10.00);
        system.addItem(item1);
        Item item2 = new Item("Toffee", 20.00);
        system.addItem(item2);
        Item item3 = new Item("sweets", 50.00);
        system.addItem(item3);

        
        system.displayItems();

        // To make shopping
        ShoppingCart cart = new ShoppingCart();
        while (true) {
            
            System.out.print("Enter an item name to add to your cart (or 'done' to finish shopping): ");
            String input = scanner.nextLine();
            if (input.equals("done")) {
                break;
            }
            Item item = system.finditemByName(input);
            if (item == null) {
                System.out.println("Item not found");
            } else {
           
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); 
                
                // Add the items to the cart
                cart.addElement(new CartElement(item, quantity));
            }
        }

        
        System.out.println("Your cart:");
        cart.displayCart();

        // customers add their name and address for shipping 
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        // Customer create an arder and add it to the cart
        Order order = new Order(name, address, cart);
        system.placeOrder(order);

       
        System.out.println("Your order:");
        order.displayOrder();

        // To make shipping
        while (true) {
           
            System.out.print("Enter an order ID to ship (or 'done' to finish shipping): ");
            String input = scanner.nextLine();
            if (input.equals("done")) {
                break;
            }
            int orderId = Integer.parseInt(input);
            system.shipOrder(orderId);
        }

       
        system.displayOrders();
    }

    public Item finditemByName(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public Order findOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
}

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class CartElement {
    private Item item;
    private int quantity;

    public CartElement(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return item.getName() + " x " + quantity + " ($" + getTotalPrice() + ")";
    }
}

class ShoppingCart {
    private ArrayList<CartElement> elements;

    public ShoppingCart() {
        elements = new ArrayList<>();
    }

    public void addElement(CartElement element) {
        elements.add(element);
    }

    public void removeElement(CartElement element) {
        elements.remove(element);
    }

    public ArrayList<CartElement> getElements() {
        return elements;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartElement element : elements) {
            totalPrice += element.getTotalPrice();
        }
        return totalPrice;
    }

    public void displayCart() {
        for (CartElement element : elements) {
            System.out.println(element);
        }
    }
}

class Order {
    private static int nextId = 1;

    private int id;
    private String customerName;
    private String customerAddress;
    private ShoppingCart cart;
    private boolean shipped;

    public Order(String customerName, String customerAddress, ShoppingCart cart) {
        this.id = nextId++;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void ship() {
        shipped = true;
    }

    public void displayOrder() {
        System.out.println("Order #" + id);
        System.out.println("Customer: " + customerName);
        System.out.println("Address: " + customerAddress);
        System.out.println("Cart items:");
        cart.displayCart();
        System.out.println("Total price: $" + cart.getTotalPrice());
    }

    @Override
    public String toString() {
        return "Order #" + id + " - " + customerName + " (" + customerAddress + ") - " + (shipped ? "shipped" : "not shipped");
    }
}
