
/*public class BOXTest { 
	public static void main(String args[]){
		 BOX b1 = new BOX(10,40,60);
		 BOX b2 = new BOX(20,30,80);
		 System.out.println(b1);
		 System.out.println(b2);
		 BOX.swapBoxes(b1,b2);
		 System.out.println(b1);
		 System.out.println(b2);
	}
}
*/
/*In this the changes are not reflected in the main method because the swapping of variables is for the othe other method variables*/

public class BOXTest{
public static void main(String args[]){
	 BOX b1 = new BOX(10,40,60);
	 BOX b2 = new BOX(20,30,80);
	 System.out.println(b1);
	 System.out.println(b2);
	 BOX.swapBoxes(b1, b2);
	 System.out.println(b1);
	 System.out.println(b2);
	 BOX temp = b1;
	 b1 = b2;
	 b2 = temp;
	 System.out.println(b1);
	 System.out.println(b2);
}
}//End of Main


class BOX {
		private double length, width, height; // Instance Fields
		
		BOX(double l,double b,double h){ // Constructor Method
		length = l; width = b; height =h;
		}
		
		
		// Mutator methods for Length, Width and Height
		public void setLength(double l) { length = l;}
		public void setWidth(double b) { width = b;}
		public void setHeight(double h) { height = h;}
		
		
		// Accessor Methods for Length, Width and Height
		public double getLength() { return length;}
		public double getWidth() { return width; }
		public double getHeight() { return height;}
		
		public String toString() { 
			return "Length:"+length+" Width:"+width+" Height:"+height;
		}
		
		public double area() {
			return 2 * (length * width + width*height +	height*length);
		}
		
		public double volume() { 
			return length*width*height;
		}
		
		public static void swapBoxes(BOX b1, BOX b2) {
			BOX temp = b1; b1 = b2; b2 = temp;
		}
}// End of BOX