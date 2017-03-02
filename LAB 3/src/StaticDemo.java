class StaticDemo {
	public static void main(String args[]){
		 MyStatic s1 = new MyStatic ();
		 s1.showData();
		 MyStatic s2 = new MyStatic ();
		 s2.showData();
		 MyStatic.b++;
		 s1.showData();
		 }

}

 class MyStatic {
 int a; //initialized to zero
 
 static int b; 
 /*initialized to zero only when class is
loaded not for each object created.*/
 
 
 //Constructor incrementing static variable b
  MyStatic (){ b++; }
 
 
 public void showData(){
 System.out.println("Value of a = "+a);
 System.out.println("Value of b = "+b);
 }

 //public static void increment(){
 //a++;
 //}
 }