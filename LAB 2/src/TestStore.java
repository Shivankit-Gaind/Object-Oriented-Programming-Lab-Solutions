import java.util.Scanner; 

class Item {
	private String itemName;
	private String itemidNo;
	private int itemQuantity;
	private double itemPrice;
	
	Item(String name, String id, int quantity, double price){
		itemName= name;
		itemidNo= id;
		itemQuantity= quantity;
		itemPrice= price;
	}
	Item(String name, String id, int quantity){
		itemName= name;
		itemidNo= id;
		itemQuantity= quantity;
		itemPrice= 500;
	}
	
	Item(String name, String id){
		itemName= name;
		itemidNo= id;
		itemQuantity= 1;
		itemPrice= 500;
	}
	/**Mutators**/
	public void set_itemName(String name){
		itemName= name;
	}
	public void set_itemidNo(String id){
		itemidNo= id;
	}
	public void set_itemQuantity(int quantity){
		itemQuantity= quantity;
	}
	public void set_itemPrice(double price){
		itemPrice= price;
	}
	
	/**Accessors**/
	public String get_itemName(){
		return itemName;
	}
	public String get_itemidNo(){
		return itemidNo;
	}
	public int get_itemQuantity(){
		return itemQuantity;
	}
	public double get_itemPrice(){
		return itemPrice;
	}
	
}


class Customer{
	private String name;
	private String idNo;
	private double balance;
	private Item item;
	
	Customer(String name, String id, double balance){
		this.name= name;
		idNo= id;
		this.balance=balance;
	}
	
	Customer(String name, String id){
		this.name= name;
		idNo= id;
		this.balance=5000;
	}
	/**Mutators**/
	public void set_name(String name){
		this.name= name;
	}
	public void set_idNo(String id){
		this.idNo= id;
	}
	
	/**Accessors**/
	
	public String get_name(){
		return name;
	}
	public String get_idNo(){
		return idNo;
	}
	public double get_balance(){
		return balance;
	}
	public Item get_item_details(){
		return item;
	}
	
	public void print_item_details(){
		System.out.println("Details:");
		System.out.println("Item Name- "+item.get_itemName());
		System.out.println("Item ID- "+item.get_itemidNo());
		System.out.println("Item Quantity- "+item.get_itemQuantity());
		System.out.println("Item Price- "+item.get_itemPrice());
	}
	
	public void buyItem(Item brought_item){
		if(balance<(brought_item.get_itemPrice()*brought_item.get_itemQuantity())){
			System.out.println("Insufficient balance");
			return;
		}
		else if(brought_item.get_itemQuantity()<2){
			System.out.println("Order not valid");
		}
		else{
			item=brought_item;
			this.balance-=((brought_item.get_itemQuantity())*(brought_item.get_itemPrice()));
			print_item_details();
			System.out.println("Current Balance- "+this.balance);
		}
	}
}
	


public class TestStore {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Customer name:");
		String name=in.nextLine();
		System.out.println("Enter the Customer id:");
		String id=in.nextLine();
		System.out.println("Enter the Customer Balance:");
		double balance=in.nextDouble();
		
		Customer c1= new Customer(name,id,balance);	
		
		System.out.println("Item1:");
		System.out.println("Enter the Item name:");
		in.nextLine();
		name=in.nextLine();
		System.out.println("Enter the Item id:");
		id=in.nextLine();
		System.out.println("Enter the Item Quantity:");
		int quantity=in.nextInt();
		System.out.println("Enter the Item Price:");
		double price=in.nextDouble();
		
		Item item1=new Item(name,id,quantity,price);
		
		System.out.println("Item2:");
		System.out.println("Enter the Item name:");
		in.nextLine();
		name=in.nextLine();
		System.out.println("Enter the Item id:");
		id=in.nextLine();
		System.out.println("Enter the Item Quantity:");
		quantity=in.nextInt();
		System.out.println("Enter the Item Price:");
		price=in.nextDouble();
		
		Item item2=new Item(name,id,quantity,price);
		
		c1.buyItem(item1);
		c1.buyItem(item2);		
	}
}