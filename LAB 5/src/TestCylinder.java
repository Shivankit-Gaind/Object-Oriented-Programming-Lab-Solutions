// Define the Circle class
class Circle { // Save as "Circle.java"
// Private variables
 private double radius;
 private String color;
 
// Constructors (overloaded)
 public Circle() { // 1st Constructor
 radius = 1.0;
 color = "red";
 }
 public Circle(double r) { // 2nd Constructor
 radius = r;
 color = "red";
 }
 public Circle(double r, String c) { // 3rd Constructor
 radius = r;
 color = c;
 }
// Public methods

 public double getRadius() {
 return radius;
 }
 public String getColor() {
 return color;
 }
 public double getArea() {
 return radius*radius*Math.PI;
 }
}


//Define Cylinder class, which is a subclass of Circle
class Cylinder extends Circle {
private double height; // Private member variable
public Cylinder() { // constructor 1
super(); // invoke superclass' constructor Circle()
height = 1.0;
}
public Cylinder(double radius, double height) { // Constructor 2
super(radius); // invoke superclass' constructor Circle(radius)
this.height = height;
}
public double getHeight() {
return height;
}
public void setHeight(double height) {
this.height = height;
}
public double getVolume() {
return getArea()*height; // Use Circle's getArea()
}
}


//A test driver program for Cylinder class
public class TestCylinder {
public static void main(String[] args) {
Cylinder cy1 = new Cylinder(); // Use constructor 1
System.out.println("Radius is " + cy1.getRadius()
+ " Height is " + cy1.getHeight()
+ " Color is " + cy1.getColor()
+ " Base area is " + cy1.getArea()
+ " Volume is " + cy1.getVolume());
Cylinder cy2 = new Cylinder(5.0, 2.0); // Use constructor 2

System.out.println("Radius is " + cy2.getRadius()
+ " Height is " + cy2.getHeight()
+ " Color is " + cy2.getColor()
+ " Base area is " + cy2.getArea()
+ " Volume is " + cy2.getVolume());
}
}





