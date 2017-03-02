public class ConstructorBlockExample {
	{ 
	 System.out.println("This is first constructor block"); 
	}
	public ConstructorBlockExample(){
	 System.out.println("This is no parameter constructor");
	}
	 
	public ConstructorBlockExample(String param1){
	 System.out.println("This is single parameter constructor");
	}
	
	{ 
	 System.out.println("This is second constructor block"); 
	}
	 
	public static void main(String[] args){
	 ConstructorBlockExample constrBlockEx = new ConstructorBlockExample();
	 ConstructorBlockExample constrBlockEx1 = new ConstructorBlockExample("param1");
	}
}

//The blocks here will be implemented every time the object is instantiated, even before the actual constructor method. These are called constructor blocks and all such blocks
//will have their one copy in each constructor method, so they will be implemented whenever a constructor is called  
