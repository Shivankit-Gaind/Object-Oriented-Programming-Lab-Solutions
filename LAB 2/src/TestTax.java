import java.util.Scanner; 

public class TestTax {
	public static void main(String args[]){
		TaxOnSalary tax1 = new TaxOnSalary(true);
		TaxOnSalary tax2 = new TaxOnSalary();
		tax1.inputSalary();
		tax2.inputSalary();
		System.out.println("Tax1 "+tax1.caculateTax());
		System.out.println("Tax2 "+tax2.caculateTax());
	}
}

class TaxOnSalary{
	private double salary;
	private boolean isPANsubmitted;
	
	//Constructors
	TaxOnSalary(boolean isPANsubmitted){
		this.isPANsubmitted=isPANsubmitted;
		this.salary=1000.00;
	}	
	TaxOnSalary(){		
	}
	
	//Accessors
	public double getSalary(){
		return salary;
	}
	public boolean getIsPANsubmitted(){
		return isPANsubmitted;
	}
	public void inputSalary(){
		Scanner in = new Scanner(System.in);
		salary=in.nextDouble();
	}
	
	public double caculateTax(){
		if(salary < 180000 && isPANsubmitted == true){
			return 0;
		}
		else if(salary < 180000 && isPANsubmitted == false){
			return 0.05*salary;
		}
		else if( salary < 500000){
			return 0.1*salary;
		}
		else if( salary < 1000000){
			return 0.2*salary;
		}
		else{
			return 0.3*salary;
		}
	}
	
	
	
}
