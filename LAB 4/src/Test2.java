import java.util.StringTokenizer;
import java.util.Scanner;

class Address{
	private String line1;
	private String line2;
	private String line3;
	private char[] city;
	private char[] state;
	private String pin;
	
	//ACCESSORS
	public String getLine1(){
		return line1;
	}
	public String getLine2(){
		return line2;
	}
	public String getLine3(){
		return line3;
	}
	public String getCity(){
		String str = String.valueOf(city);
		// or String str = String.copyValueOf(city);
		return str;
	}
	public String getState(){
		String str = String.valueOf(state);
		// or String str = new StringBuilder(state).toString();
		return str;
	}
	public String getPin(){
		return pin;
	}
	
	//Constructor
	public Address(String address){
		
		//Use of StringTokenizer
		StringTokenizer st = new StringTokenizer(address,"$");
		String StringArray[]= new String[st.countTokens()];
		for (int i=0; st.hasMoreTokens() ;i++) {              
	    	StringArray[i] = st.nextToken();    
	    }
		this.line1=StringArray[0];
		this.line2=StringArray[1];
		this.line3=StringArray[2];
		this.pin=StringArray[5];
		
		// conversion of string to char array
		this.city=StringArray[3].toCharArray();
		this.state=StringArray[4].toCharArray();
	}
	
}

class AddressList{
	public static int countAddressWithCity(Address[] addressList, String city){
		int count=0;
		String city2;
		if(city.length()==0||city==null){
			return -1;
		}
		for(int i=0;i<addressList.length;i++){
			city2= addressList[i].getCity();
			if(city2.equals(city)){
				count++;
			}
		}
		return count;
	}
	public static int countAddressWithPin(Address[] addressList, String pin){
		int count=0;
		String pin2;
		if(pin.length()==0||pin==null){
			return -1;
		}
		for(int i=0;i<addressList.length;i++){
			pin2= String.valueOf(addressList[i].getPin());
			if(pin2.equals(pin)){
				count++;
			}
		}
		return count;
	}
	public static Address[] getAddressWithCity(Address[] addressList, String city){
		Address a[]=new Address[addressList.length];
		int j=0;
		String city2;
		if(city.length()==0||city==null||addressList.length==0){
			return null;
		}
		for(int i=0;i<addressList.length;i++){
			city2= String.valueOf(addressList[i].getCity());
			if(city2.equals(city)){
				a[j++]=addressList[i];
			}
		}
		if(a.length==0){
			return null;
		}
		return a; 
	}
	public static Address[] getAddressWithPin(Address[] addressList, String strP){
		Address a[]=new Address[addressList.length];
		int j=0;
		if(strP.length()==0||strP==null||addressList.length==0){
			return null;
		}
		for(int i=0;i<addressList.length;i++){		
			if(addressList[i].getPin().equals(strP)){
				a[j++]=addressList[i];
			}
		}
		if(a.length==0){
			return null;
		} 
		return a; 
	}
}

public class Test2{
	public static void main(String args[]){
		Address a[]=new Address[5];
		Scanner in = new Scanner(System.in);
		String s[] = new String[6];
		String address;
		for(int i=0;i<5;i++){
			System.out.println("Address "+(i+1)+":");
			s[0]= in.nextLine(); 
			s[1]= in.nextLine(); 
			s[2]= in.nextLine(); 
			s[3]= in.nextLine(); 
			s[4]= in.nextLine(); 
			s[5]= in.nextLine();
			address=s[0]+"$"+s[1]+"$"+s[2]+"$"+s[3]+"$"+s[4]+"$"+s[5];
			a[i] = new Address(address);
		}
		int count;
		count= AddressList.countAddressWithCity(a,"Chandigarh");
		System.out.println(count);
		count= AddressList.countAddressWithPin(a,"#123");
		System.out.println(count);   
		
		Address b1[] = AddressList.getAddressWithCity(a,"Chandigarh");
		Address b2[] = AddressList.getAddressWithPin(a,"#123");
		for(int i=0;i<b1.length;i++){
			if(b1[i]==null){
				break;
			}
			System.out.println(b1[i].getLine1()+" "+b1[i].getLine2()+" "+b1[i].getLine3()+" "+
							   b1[i].getCity()+" "+b1[i].getState()+" "+b1[i].getPin());
		}
		for(int i=0;i<b2.length;i++){
			if(b2[i]==null){
				break;
			}
			System.out.println(b2[i].getLine1()+" "+b2[i].getLine2()+" "+b2[i].getLine3()+" "+
		                       b2[i].getCity()+" "+b2[i].getState()+" "+b2[i].getPin());
		}
	}	
}