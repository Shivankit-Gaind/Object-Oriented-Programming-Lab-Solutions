import java.util.*;
class Account {  
	private long acctNumber;  
	private double balance;   
	private String name; 
 
	//Constructor	
	public Account(long acctNumber, double balance, String name){
		this.acctNumber=acctNumber;
		this.balance= balance;
		this.name= name;
	}
	
	//Accessors
	public long getAcctNumber(){
		return acctNumber;
	}
	public double getBalance(){
		return balance;
	}
	public String getName(){
		return name;
	}
	
	//Mutators
	public void setAcctNumber(long acctNumber){
		this.acctNumber=acctNumber;
	}
	public void setBalance(double balance){
		this.balance= balance;
	}
	public void setName(String name){
		this.name= name;
	}
	
	// ToString 
	public String toString(){
		return "Account: "+name+" Balance: "+balance+" Account No. "+acctNumber;
	}
}

class Bank{
	private ArrayList<Account> accts = new ArrayList<Account>(); 
	int maxActive; 	
	public boolean addAccount (Account newone){
		if(accts.size()>30){
			return false;
		}
		else{
			accts.add(newone);
			return true;
		}
	}
	public boolean removeAccount (long acctnum){
		Account a;
		Iterator<Account> itr= accts.iterator();
		while(itr.hasNext()){
			a=itr.next();
			if(a.getAcctNumber()==acctnum){
				itr.remove();
				return true;
			}
		}
		return false;
	 }
	 public double deposit(long acctnum, double amount) {
		 Account a;
		 Iterator<Account> itr= accts.iterator();
		 while(itr.hasNext()){
				a=itr.next();
				if(a.getAcctNumber()==acctnum){
					a.setBalance(a.getBalance()+amount);
					return a.getBalance();
				}
			}
			return -1;
	 }
	 public double withdraw(long acctnum, double amount) {
		 Account a;
		 Iterator<Account> itr= accts.iterator();
		 while(itr.hasNext()){
				a=itr.next();
				if(a.getAcctNumber()==acctnum){
					a.setBalance(a.getBalance()-amount);
					return a.getBalance();
				}
			}
			return -1;
	 }
	 
	 public String toString(){
			String str="";
			for(int i=0;i<accts.size();i++){
				str+=accts.get(i).toString();
				str+="\n";
			}
			return str;
		}	 
}

public class DriverCode{
	public static void main(String args[]){
		Bank b = new Bank();
		b.addAccount(new Account(24000,200,"Shivankit1"));
		b.addAccount(new Account(25000,300,"Shivankit2"));
		b.addAccount(new Account(26000,400,"Shivankit3"));
		b.addAccount(new Account(27000,500,"Shivankit4"));
		b.addAccount(new Account(28000,600,"Shivankit5"));
		System.out.println(b);
		b.removeAccount(27000);
		System.out.println(b);
		b.deposit(26000, 400);
		System.out.println(b);
		b.withdraw(28000, 300);
		System.out.println(b);
		
	}
}
