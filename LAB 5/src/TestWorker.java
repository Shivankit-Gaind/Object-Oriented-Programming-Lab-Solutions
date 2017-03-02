abstract class worker{
	private String name;
	private double salary_rate;
	
	public worker(String name,double salary_rate){
		this.name=name;
		this.salary_rate=salary_rate;
	}
	public String getNmae(){
		return name;
	}
	public double getsalary(){
		return salary_rate;
	}
	abstract public double computePay();
}

class FulltimeWorker extends worker{
	private int hours_worked;
	public FulltimeWorker(String name,double salary_rate,int hours_worked){
		super(name,salary_rate);
		this.hours_worked = hours_worked;
	}
	public double computePay(){
		if(hours_worked>240){
			return 240*super.getsalary();
		}
		else{
			return this.hours_worked*super.getsalary();
		}
	}
}

class HourlyWorker extends worker{
	private int hours_worked;
	public HourlyWorker(String name,double salary_rate,int hours_worked){
		super(name,salary_rate);
		this.hours_worked = hours_worked;
	}
	public double computePay(){
		if(hours_worked>60){
			return 60*super.getsalary();
		}
		else{
			return this.hours_worked*super.getsalary();
		}
	}
}

public class TestWorker{
	public static void main(String args[]){
		System.out.println(new FulltimeWorker("RAJESH",100,58).computePay());
		System.out.println(new HourlyWorker("RAJESH",50,80).computePay());
	}
}