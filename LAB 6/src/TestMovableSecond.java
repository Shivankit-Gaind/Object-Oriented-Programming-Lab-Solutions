import java.util.*;
interface Movable {
	 // abstract methods to be implemented by the subclasses
	 public void moveUp();
	 public void moveDown();
	 public void moveLeft();
	 public void moveRight();
}

class MovablePoint implements Movable, Comparable<MovablePoint> {
	 
	 int x, y, xSpeed, ySpeed; 

	 // Constructor
	 public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
	 this.x = x;
	 this.y = y;
	 this.xSpeed = xSpeed;
	 this.ySpeed = ySpeed;
	 }

	 public String toString() {
	 return "Point at (" + x + "," + y + ") XSPEED: "+ xSpeed+" YSPEED: "+ySpeed;
	 }
	 // Implement abstract methods defined in the interface Movable

	 public void moveUp() {
	 y-=ySpeed;
	 }

	 public void moveDown() {
	 y+=ySpeed;
	 }

	 public void moveLeft() {
	 x-=xSpeed;
	 }

	 public void moveRight() {
	 x+=xSpeed;
	 }
	 
	 public int compareTo (MovablePoint point){
		 if(this.x==point.x){
			 return (int)(this.y-point.y);
		 }
		 else{
			 return (int)(this.x-point.x);
		 }
	 }
}

class MovableCircle implements Movable {
	 // instance variables
	 private MovablePoint center; // can use center.x, center.y directly because they are package accessible
	 private int radius;
	 
	 //accessor for radius
	 public int getRadius(){
		 return radius;
	 }
	 public MovablePoint getCenter(){
		 return center;
	 }

	 // Constructor
	 public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
	 // Call the MovablePoint's constructor to allocate the center instance.
	
	 center = new MovablePoint(x, y, xSpeed, ySpeed);
	 this.radius = radius;
	 }

	 // Implement abstract methods declared in the interface Movable
	 
	 public void moveUp() {
	 center.y -= center.ySpeed;
	 }
	
	 public void moveDown() {
	 center.y += center.ySpeed;
	 }
	
	 public void moveLeft() {
	 center.x -= center.xSpeed;
	 }
	
	 public void moveRight() {
	 center.x += center.xSpeed;
	 }
	 
	 public String toString() {
		 return "Center at (" + center.x + "," + center.y + ") XSPEED: "+ center.xSpeed+" YSPEED: "+center.ySpeed+" RADIUS: "+this.radius;
	 }
		 
	
}

//no need of comparable and comparator here but still for practice I have included

class CompareByRadius implements Comparator<MovableCircle>{
	public int compare(MovableCircle m1, MovableCircle m2){
		return (int)(m1.getRadius()-m2.getRadius());
	}
}

class CompareByCenter implements Comparator<MovableCircle>{
	public int compare(MovableCircle m1, MovableCircle m2){
		return (int)(m1.getCenter().compareTo(m2.getCenter()));
	}
}
class CompareByBoth implements Comparator<MovableCircle>{
	public int compare(MovableCircle m1, MovableCircle m2){
		if(m1.getRadius()==m2.getRadius())
			return (int)(m1.getCenter().compareTo(m2.getCenter()));
		else
			return (int)(m1.getRadius()-m2.getRadius());
	}
}

public class TestMovableSecond {
	 public static void main(String[] args) {
		 Movable m1 = new MovablePoint(5, 6, 10,20); // upcast
		 System.out.println(m1);
		 m1.moveLeft();
		 System.out.println(m1);

		 Movable m2 = new MovableCircle(2, 1, 2, 20, 25); // upcast
		 System.out.println(m2); //toString method will be called from 
		 m2.moveRight();
		 System.out.println(m2);		 
		 //WE CAN USE COMPARATOR AND COMPARABLE NOW	TO SORT ARRAY OF MOVABLE CIRCLES AND MOVABLE POINTS 
	 }
}
