import java.util.Scanner;
import java.util.Vector;
import java.io.*;

class Pokemon {    
	private String name; // Name of the Pokemon     
	private int id; // id of the Pokemon     
	private String type; // type of the Pokemon
	
	//ACCESSORS
	public String getName(){
		return this.name;
	}
	public int getId(){
		return this.id;
	}
	public String getType(){
		return this.type;
	}
	
	
	//CONSTRUCTOR
	public Pokemon(String pokemon){
		 for(int i=0;i<pokemon.length();i++){
			 if(pokemon.charAt(i)=='|'){
				 String parts[]= pokemon.split(",");
				 this.name=parts[0];
				 this.id=Integer.parseInt(parts[1]);
				 this.type=parts[2];
				 break;
			 }
			 else if(pokemon.charAt(i)==';'){
				 String parts[]= pokemon.split(";");
				 this.id=Integer.parseInt(parts[0]);
				 this.name=parts[1];
				 this.type=parts[2];
				 break;
			 }
		 }
	}
	
	//TO STRING 
	public String toString(){
		return id+" "+name+" "+type;
	}
	
	public String getPokemon(){
		return id+"\n"+name+"\n"+type;
	}	
}

class Pokeball {
	private Pokemon pokemon;
	
	//CONSTRUCTOR
	public Pokeball(Pokemon pokemon){
		this.pokemon=pokemon;
	}
	
	//ACCESSOR
	public Pokemon getPokemon(){
		return this.pokemon;
	}
	
	//MUTATOR
	public void setPokemon(Pokemon pokemon){
		this.pokemon=pokemon;
	}
	
	//To String
	public String toString(){
		return pokemon.getId()+" "+pokemon.getName()+" "+pokemon.getType();
	}	
}

class Trainer{
	public static Vector<Pokeball> collection = new Vector<Pokeball>();
	
	public static void capturePokemon(Pokemon pokemon){
		Pokeball pokeball= new Pokeball(pokemon); //It creates a pokeball with a pokemon and adds to the list
		collection.add(pokeball);
	}
	
	public static Pokemon[] getPokemonWithType(String type){
		Pokemon a[]= new Pokemon[collection.size()];
		int j=0;
		for(Pokeball pokeball:collection){
			if(pokeball.getPokemon().getType().equals(type)){
				a[j++]=pokeball.getPokemon();
			}
		}
		if(a.length==0){
			return null;
		}
		return a;
	}
	
	 public static Pokemon[] getPokemonsWithGivenTypes(String[] types){
		 Pokemon a[]= new Pokemon[collection.size()];
			int j=0;
			int flag;
			for(Pokeball pokeball:collection){
				flag=0;
				for(int i=0;i<types.length;i++){
					if(pokeball.getPokemon().getType().equals(types[i])){
						flag=1;
						break;
					}
				}
				if(flag==1){
					a[j++]=pokeball.getPokemon();
				}				
			}
			if(a.length==0){
				return null;
			}
			return a;
	 }
	
	public static Pokemon[] getPokemonsInRange(int minId, int maxId) {
		Pokemon a[]= new Pokemon[collection.size()];
		int j=0;
		for(Pokeball pokeball:collection){
			if(pokeball.getPokemon().getId()<=maxId && pokeball.getPokemon().getId()>=minId ){
				a[j++]=pokeball.getPokemon();
			}
		}
		if(a.length==0){
			return null;
		}
		return a;
	}
}

public class Test3{
	 public static Pokemon readPokemon() throws IOException{
			Scanner in = new Scanner(System.in); 
			System.out.println("Enter Pokemon Name");
			String name=in.nextLine();
			System.out.println("Enter Pokemon Id");
			int id = in.nextInt();
			in.nextLine();
			System.out.println("Enter Pokemon type");
			String type=in.nextLine();
			System.out.println("Enter Pokemon Name Format");
			int x = in.nextInt();
			
			
			String NAME=null;
			
			if(x==1){
				 NAME = name + "," + id + "," + type;			
			}
			else{
				 NAME = id + ";" + name + ";" + type;	
			}
			
			Pokemon p = new Pokemon(NAME);
			return p;
	 }
	 
	 public static void main(String args[]) throws IOException{
		 
		 Pokemon p;
		 for(int i=0;i<15;i++){
			p = readPokemon();
			Trainer.capturePokemon(p);
		 }
		 
		 Pokemon list1[]=Trainer.getPokemonWithType("Fire");
		 for(int i=0;i<list1.length;i++){
			if(list1[i]!=null){
				System.out.println(list1[i]);
			}	
			else{
				break;
			}
		 }
		 
		 String str[]={"Grass","Fire","Bug","Water"};
		 Pokemon list2[]=Trainer.getPokemonsWithGivenTypes(str);
		 for(int i=0;i<list2.length;i++){
			if(list2[i]!=null){
				System.out.println(list2[i]);
			}	
			else{
				break;
			}
		 }
		 
		 Pokemon list3[]=Trainer.getPokemonsInRange(13,26);
		 for(int i=0;i<list3.length;i++){
			if(list3[i]!=null){
				System.out.println(list3[i]);
			}	
			else{
				break;
			}
		 }		 
	 }	 
}