/*
class Circle{
 static double PI; /* variables PI is a class variable, it is not instance specific */
/*
 private double radius;

 Circle(double radius) {
 this.radius = radius; 
 Circle.PI = 3.141;
 System.out.println("NEW CIRCLE:");
 }
 //accessor method
 public double getRadius() { 
	 return radius; 
}
 
 //mutator method
 public void setRadius(double radius) {
	 this.radius = radius; 
}

 //method to find the area
 public void area() { 
	 System.out.println("Area= "+(PI * radius * radius)); 
}
 
 //static method's are not instance specific
 public static void getCircumference(double radius) {
 // here radius variable is a local variable and PI is a class variable i.e static variable
 System.out.println("Circumference = " + 2 * PI * radius);
 }
 
}// End of circle

class TestCircle {
	public static void main(String args[]) {
		 Circle c1 = new Circle(2.3);
		 c1.area();
		 
		 // accessing static method with class name
		 Circle.getCircumference(2.3);
		 
		 Circle c2 = new Circle(3.45);
		 c2.area();
		 
		 // accessing static method with references is discouraged
		 c2.getCircumference (3.45);
		 
		 /* 1. Make the area function as static and observe the
		output
		 2. Remove the formal argument from getCircumference()
		method and observe the output
		 3. Rename static to final and observe the error(s) and
		correct them *//*
		 } // end of main
}

/* 1. If we make area function static, it gives compile time error because a static method cannot access non static variables*/
/* 2. Same issue, it gives compile time error because a static method cannot access non static variables*//*

*/
 class Circle{
 final double PI; // variables PI is a class variable, it is not instance specific 
 private double radius;

 Circle(double radius) {
 this.radius = radius; 
 this.PI = 3.141;
 System.out.println("NEW CIRCLE:");
 }
 //accessor method
 public double getRadius() { 
	 return radius; 
}
 
 //mutator method
 public void setRadius(double radius) {
	 this.radius = radius; 
}

 //method to find the area
 public void area() { 
	 System.out.println("Area= "+(PI * radius * radius)); 
}
 
 //static method's are not instance specific
 public final void getCircumference(double radius) {
 // here radius variable is a local variable and PI is a class variable i.e static variable
 System.out.println("Circumference = " + 2 * PI * radius);
 }
 
}// End of circle

class TestCircle {
	public static void main(String args[]) {
		 Circle c1 = new Circle(2.3);
		 c1.area();
		 
		 // accessing static method with class name
		 c1.getCircumference(2.3);
		 
		 Circle c2 = new Circle(3.45);
		 c2.area();
		 
		 // accessing static method with references is discouraged
		 c2.getCircumference (3.45);
		 
		 /* 1. Make the area function as static and observe the
		output
		 2. Remove the formal argument from getCircumference()
		method and observe the output
		 3. Rename static to final and observe the error(s) and
		correct them */
		 } // end of main
}

