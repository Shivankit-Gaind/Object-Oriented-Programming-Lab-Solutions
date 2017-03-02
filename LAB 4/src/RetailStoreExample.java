class RetailStore {          
	private int[] itemId;  
	private double[] price;   
	private String itemName[];    
	
	/* The constructor is used here for the initialization purpose*/ 
	public RetailStore(){   
		itemId = new int[] { 1001, 1002, 1003, 1004, 1005 }; 
		//itemId = { 1001, 1002, 1003, 1004, 1005 };  wont work
		
		price = new double[] { 950.00, 750.00, 450.00, 350.00, 250.00 };
		
		itemName = new String[] {  "Yonex Tennis Racket-950",
								   "Yonex Badminton Racket-750",
								   "Silvers Badminton Racket-450",
								   "Cosco Badminton shuttle-350", 
								   "Cosco Tennis Racket-250" };  
	}  
	
	protected double computePrice(int value) {  
		// method to compute the price of the item. it returns the price  
		for (int i = 0; i<itemId.length; ++i) {    
		 // note the use of price.length. it gives the length of the array    
			if (itemId[i] == value){     
				return price[i];    
			}  
		}   
	    return price[value];  
	}  
	protected String fetchDescription(int value) {   
	 // method to compute the description of the item. it returns the  
	 // description 
		for (int i = 0; i<itemId.length; ++i) {    
		// note the use of price.length. it gives the length of the array   
			if (itemId[i] == value){    
			  return itemName[i];    
			}  
		}  
		return null;  
	} 
}

public class RetailStoreExample extends RetailStore {
	 public static void main(String[] args) {
		  int index;
		  RetailStore retailOne = new RetailStore();
		  String description = retailOne.fetchDescription(1004);
	
		  // below line illustrates the use of split function of String class   
		  String StringArray[];
		  // below line split the string and stores the splitted values to an   array  
		  StringArray = description.split("\\s");
	
		  /* this commented code illustrates the use of StringTokenizer to achieve the same functionality of split method 
		    
		    StringTokenizer st = new StringTokenizer(description);    
		    StringArray = new String[st.countTokens()];               
		    for (int i=0; st.hasMoreTokens() ;i++) {              
		    	StringArray[i] = st.nextToken();    
		    }
		        
		   */
		  String type = StringArray[2];
		  System.out.println("the type of the item is " + type);
		  System.out.println("the charactor at starting position is " + type.charAt(0));
		  
		  // below line will find the location of the symbol "-"   
		  index = type.indexOf('-');		  
		  String stringFromSubstring = type.substring(index + 1);		  
		  System.out.println("the price computed using the substring method is " + stringFromSubstring);
		  
		  String stringFromDouble = Double.toString(new RetailStore().computePrice(1004));
		  System.out.println("the price of the item computed using double.toString method is " + stringFromDouble);
		  // This method is converting the double value received to string , We also have Integer.toString(int x) method
		  
		  //Exercise
		  
		  index= stringFromDouble.indexOf('.');
		  String stringFromSubstring2 = stringFromDouble.substring(0,index);
		  System.out.println(stringFromSubstring2);
		  if(stringFromSubstring.equals(stringFromSubstring2)){
			  System.out.println("True");
		  }
		  else{
			  System.out.println("False");
		  }
	 }
}

