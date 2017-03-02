// Demonstrating the use of Overloaded constructors
class OverloadConstructors {
public static void main(String args[]) {
Room a=new Room(20,30,40);
Room b=new Room();
Room c=new Room(10);
double vol;
vol=a.volume();
System.out.println("Volume of room a is " + vol);
vol=b.volume();
System.out.println("Volume of room b is " + vol);
vol=c.volume();
System.out.println("Volume of room c is " + vol);
}
}

class Room {
double length,breadth,height;
Room(){//default construcor for class Room
length=-1;
breadth=-1;
height=-1;
}
//overloading the constructor
//3 Parameterised constructor for the class Room
Room(double l,double b,double h) {
length=l;
breadth=b;
height=h;
}
Room(double len) { // Single parametrised constructor
length=breadth=height=len;
}
public double volume() {
return length*breadth*height;
}
}