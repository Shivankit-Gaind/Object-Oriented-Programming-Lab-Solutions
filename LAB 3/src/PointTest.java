public class PointTest {
	public static void main(String args[]){
		// Pass By Reference
		Point p1 = new Point(10,20);
		System.out.println(p1); // See the o/p for this line, this is going to call toString() method
		Point.changeState(p1);
		System.out.println(p1); // See the o/p for this line, this is going to call toString() method
		
		// Pass By value
		Point p2 = new Point(100,200);
		System.out.println(p2); // See the o/p for this line, this is going to call toString() method
		Point.changeReference(p2);
		System.out.println(p2); // See the o/p for this line, this is going to call toString() method
	} // End of Method main()

}


class Point {

	 private double x; // Instance field x-coordinate
	 private double y; // Instance field y-coordinate

	 Point(double x, double y) { 
		 this.x=x; 
		 this.y=y; 
	}


	 public double getX() { return this.x; }
	 public double getY() { return this.y; }
	 public void setX(double x) { this.x = x; }
	 public void setY(double y) { this.y = y; }

	 public String toString() { 
		 return "X="+x+" Y ="+y ; 
	}

	 public static void changeState(Point other) {
	 other.setX(-20); 
	 // Here you can write other.x = 20 also because this code is inside the class
	 
	 other.setY(-20); 
	 // Here you can write other.y = 20 also because this code is inside the class
	 // Note that changeState Method changing the state of the Passed object by using the same reference
	 // So this change in state will be reflected in caller method also
	}
	 
	 public static void changeReference(Point other){
		 other = new Point(-20,-20); 
	 // Will this change be reflected in caller method?
	 // Note that this Method has changed the reference from incoming Point object to some other Point object
	 // So this change will not be reflected in caller method.
	 }
	 
	} // End of class Point
