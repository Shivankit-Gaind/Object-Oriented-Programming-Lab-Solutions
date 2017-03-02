import java.util.ArrayList; 
 
public class ArrayListDemo {  
	public static void main(String[] args) {   
	//Creating a new ArrayList   
	ArrayList<String> arlTest = new ArrayList<String>();   
	//Size of arrayList   
	System.out.println("Size of ArrayList at creation: " +arlTest.size());   
	//Lets add some elements to it   
	arlTest.add("B");   
	arlTest.add("I");  
	arlTest.add("T");   
	arlTest.add("S");   
	//Recheck the size after adding elements   
	System.out.println("Size of ArrayList after adding elements: "+arlTest.size());   
	//Display all contents of ArrayList   
	System.out.println("List of all elements: " + arlTest);   
	//Remove some elements from the list   
	arlTest.remove("B");   
	System.out.println("See contents after removing one element: " + arlTest);   
	//Remove element by index   
	arlTest.remove(2);   
	System.out.println("See contents after removing element by index: " + arlTest);  
	//Check size after removing elements   
	System.out.println("Size of arrayList after removing elements: " + arlTest.size());   
	System.out.println("List of all elements after removing elements: " + arlTest);  
  //Check if the list contains "T"   
	System.out.println(arlTest.contains("T")); 
	} 
} 
 