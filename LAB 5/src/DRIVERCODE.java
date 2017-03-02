class Employee{
	private String name;
	private double salary;	
	
	public Employee(String name,double salary){
		this.name=name;
		this.salary=salary;
	}
	public String getName(){
		return name;
	}
	public double getsalary(){
		return salary;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
	public String toString(){
		return "NAME = "+name+" SALARY = "+salary;
	}
}

class Manager extends Employee{
	private String department;
	
	public Manager(String name,double salary,String department){
		super(name,salary);
		this.department=department;
	}	
	public String getName(){
		return super.getName();
	}
	public double getsalary(){
		return super.getsalary();
	}
	public void setName(String name){
		super.setName(name);
	}
	public void setSalary(double salary){
		super.setSalary(salary);
	}
	public void setDepartment(String department){
		this.department=department;
	}
	public String getDepartment(){
		return department;
	}	
	public String toString(){
		return "NAME = "+super.getName()+" SALARY = "+super.getsalary()+" Department = "+department;
	}	
}

public class DRIVERCODE{
	public static void main(String args[]){
		Employee e = new Employee("Shivankit",4000000);
		System.out.println(e);
		Manager m = new Manager("Shivankit",8000000,"COMPUTER SCIENCE");
		System.out.println(m);
	}
}

