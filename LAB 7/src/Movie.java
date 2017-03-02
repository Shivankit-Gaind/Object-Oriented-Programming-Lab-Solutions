 class Movie{
	 
	//Declaring an interface inside the class .. 
	 interface Bookable {     
		 public void printTicket();         
		 public void giveTicket(String movie);      
	 } 
	 
	 
	 public void BookTheTicket() {  
	 // Writing an InnerClass that implements the above interface         
	 class EnglishMovie implements Bookable {            
		 String name ;          
		 public void printTicket() {             
			 giveTicket("BlindDate");            
		 } 
 
      public void giveTicket(String movie) {
    	  name = movie;             
    	  System.out.println("You have booked for the movie "+ name);            
    	  }        
      } 
 
        // creating an object for the inner class ..         
	 Bookable hollywood = new EnglishMovie(); 
 
        // anonymous innerclass which is basing the interface..         
	 Bookable hindiMovie = new Bookable() {           
		 public void printTicket() {                
			 giveTicket("Bachna Ae Haseeno");            
		 }           
		 public void giveTicket(String movie) {              
			 String name = movie;              
			 System.out.println("You have booked for the movie "+ name);            
			 }         
		 };            
		 hollywood.giveTicket("ABC");         
		 hindiMovie.giveTicket("DEF");     
	} 
 
    public static void main(String[] args) {        
    	Movie easyMovie = new Movie();         
    	easyMovie.BookTheTicket();     
    	}
 }
 
 