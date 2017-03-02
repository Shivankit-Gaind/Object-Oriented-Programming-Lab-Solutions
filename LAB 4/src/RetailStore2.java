import java.util.Vector;
public class RetailStore2 {
	
    private Vector <Item> items = new Vector <Item> ();
    public void addItem(Item item) {
        items.add(item);
    }

    private double computePrice(int value) {
        // method to compute the price of the item.          
        // it returns the price     
        for (Item item: items) {
            if (item.getId() == value) {
                return item.getPrice();
            }
        }
        // if item not found return -1.0      
        return -1.0;
    }
    
    
    public static void main(String[] args) {
        //main method. Execution begins here   
        RetailStore2 retailOne = new RetailStore2();
        retailOne.addItem(new Item(1001, 13.50));
        retailOne.addItem(new Item(1002, 18.00));
        retailOne.addItem(new Item(1003, 19.50));
        retailOne.addItem(new Item(1004, 25.50));
        retailOne.addItem(new Item(1005, 25.50));
        System.out.println("price of item id 1003 is " + retailOne.computePrice(1003));
        System.out.println("price of item id 1004 is " + retailOne.computePrice(1004));
        System.out.println("price of item id 1005 is " + retailOne.computePrice(1005));
        System.out.println("price of item id 1006 is " + retailOne.computePrice(1006));
    }
}

class Item {
    private int itemId; // ID of item    
    private double price; // name of student  

    public Item(int itemId, double price) {
        this.itemId = itemId;
        this.price = price;
    }
    public int getId() {
            return itemId;
        } //accessor method for itemid  
    
    public double getPrice() {
            return price;
        } //accessor method for price
    
} // End of class Item