public class RaceTrack {
	
	public static void main(String args[]){
		Car c1= new Car(1943,"TATA",32.65);
		System.out.println("Year "+c1.getYear());
		System.out.println("Make "+c1.getMake());
		System.out.println("Speed "+c1.getSpeed());
		
		c1.Accelerate();
		System.out.println("Speed "+c1.getSpeed());
		
		c1.Accelerate(10);
		System.out.println("Speed "+c1.getSpeed());
		
		c1.Break(4);
		System.out.println("Speed "+c1.getSpeed());
		
		/* this is not gonna work as the default constructor is now overridden
		Car c2= new Car();
		System.out.println("Year "+c2.getYear());
		System.out.println("Make "+c2.getMake());
		System.out.println("Speed "+c2.getSpeed());
		
		c1.Accelerate();
		System.out.println("Speed "+c2.getSpeed());
		
		c1.Accelerate(10);
		System.out.println("Speed "+c2.getSpeed());
		
		c1.Break(2);
		System.out.println("Speed "+c2.getSpeed());
		*/
	}	
}

class Car{
	private int year;
	private String make;
	private double speed;
	
	//Constructor
	Car(int year, String make, double speed){
		this.year=year;
		this.make=make;
		this.speed=speed;
	}
	
	//Accessors
	public int getYear(){
		return year;
	}
	public String getMake(){
		return make;
	}
	public double getSpeed(){
		return speed;
	}
	
	//Methods
	public void Accelerate(){
		speed+=1;
	}
	public void Accelerate(int increment){
		speed+=increment;
	}
	public void Break(int b){
		speed-=Math.sqrt(b);
	}
	
}
