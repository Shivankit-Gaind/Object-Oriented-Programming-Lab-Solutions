package Package2;

public class TestMovable {
	 public static void main(String[] args) {
	 Movable m1 = new MovablePoint(5, 5); // upcast
	 System.out.println(m1);
	 m1.moveDown();
	 System.out.println(m1);
	 m1.moveRight();
	 System.out.println(m1);
	 }
	}
     interface Movable {
		 // abstract methods to be implemented by the subclasses
		 public void moveUp();
		 public void moveDown();
		 public void moveLeft();
		 public void moveRight();
		}


	class MovablePoint implements Movable {
	 // Private membet variables
	 private int x, y; // (x, y) coordinates of the point

	 // Constructor
	 public MovablePoint(int x, int y) {
	 this.x = x;
	 this.y = y;
	 }

	 public String toString() {
	 return "Point at (" + x + "," + y + ")";
	 }
	 // Implement abstract methods defined in the interface Movable

	 public void moveUp() {
	 y++;
	 }

	 public void moveDown() {
	 y--;
	 }

	 public void moveLeft() {
	 x--;
	 }

	 public void moveRight() {
	 x++;
	 }
	}



