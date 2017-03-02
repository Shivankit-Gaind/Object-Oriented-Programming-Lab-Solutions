import java.util.*;

interface BinaryInterface{
	public void toBinary(int n);
}

class SignedMagnitude implements BinaryInterface{
	 ArrayList<Integer> a = new  ArrayList<Integer>();
	 int temp;
	public void toBinary(int x){
		int n = Math.abs(x);
		if(x<0){
			a.add(1);
		}
		else{
			a.add(0);
		}
		while(n!=0){
			temp=n%2;
			a.add(1,temp);
			n=n/2;
		}
		int k=a.size();
		for(int i=0;i<(8-k);i++){
			a.add(1,0);
		}
		System.out.println(a);
	}	 
}

class OneComplement implements BinaryInterface{
	 ArrayList<Integer> a = new  ArrayList<Integer>();
	 int temp;
	public void toBinary(int x){
		int n = Math.abs(x);
		while(n!=0){
			temp=n%2;
			a.add(0,temp);
			n=n/2;
		}
		int k=a.size();
		for(int i=0;i<(8-k);i++){
			a.add(0,0);
		}
		// CODE FOR CONVERTING INTO 1's COMPLEMENT
		//Also notice that One's complement is taken for the normal form, not the signed magnitude form
		
		for(int z=0;z<a.size();z++){
			if(a.get(z)==0){
				a.set(z,1);
			}
			else{
				a.set(z,0);
			}
		}
		System.out.println(a);
	}	 
}

class TwoComplement implements BinaryInterface{
	 ArrayList<Integer> a = new  ArrayList<Integer>();
	 int temp;
	public void toBinary(int x){
		int n = Math.abs(x);
		while(n!=0){
			temp=n%2;
			a.add(0,temp);
			n=n/2;
		}
		
		int k=a.size();
		for(int i=0;i<(8-k);i++){
			a.add(0,0);
		}
		// CODE FOR CONVERTING INTO 2's COMPLEMENT
		//Also notice that Two's complement is taken for the normal form, not the signed magnitude form
		int flag=0;
		for(int i=a.size()-1;i>=0;i--){
			if(flag==1){
				if(a.get(i)==0){ 
					a.set(i,1);
				}
				else{
					a.set(i,0);
				}
			}
			if(a.get(i)==1){
				flag=1;
			}
		}
		System.out.println(a);
	}		
}

public class BinaryTest{
	public static void main(String args[]){
		SignedMagnitude v1 = new SignedMagnitude();
		v1.toBinary(-16);
		OneComplement v2 = new OneComplement();
		v2.toBinary(-16);
		TwoComplement v3 = new TwoComplement();
		v3.toBinary(-16);
	}
}





