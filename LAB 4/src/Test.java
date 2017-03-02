import java.io.*;
import java.util.Scanner;

class Name {
	 private String fname; // First Name
	 private String mname; // Middle Name
	 private String lname; // Last Name
	 
	 //CONSTRUCTOR
	 Name(String name) {
		 for(int i=0;i<name.length();i++){
			 if(name.charAt(i)==','){
				 String parts[]= name.split(",");
				 this.fname=parts[0];
				 this.mname=parts[1];
				 this.lname=parts[2];
				 break;
			 }
			 else if(name.charAt(i)==';'){
				 String parts[]= name.split(";");
				 this.lname=parts[0];
				 this.mname=parts[1];
				 this.fname=parts[2];
				 break;
			 }
		 }
		
	 }
		 
	 //ACCESSORS	 
	 public String getFname(){
		 return fname;		 
	 }
	 public String getMname(){
		 return mname;		 
	 }
	 public String getLname(){
		 return lname;		 
	 }
	 
	 //GETNAME method
	 public String getName(){
		 return fname + " " + mname + " "+ lname;
	 }
	 
	 public String toString(){
		 return fname + " " + mname + " "+ lname;
	 }	 
} 

class Student {
	 private Name name; // name of student
	 private int age; // age of student
	 
	 //CONSTRUCTOR
	 public Student(Name name, int age){
		 this.name=name;
		 this.age=age;
	 }
	 
	 //ACCESSORS
	 public int getAge(){
		 return age;
	 }	 
	 public Name getName(){
		 return name;
	 }
	 
	 public String toString(){
		 return name.getFname() + " " + name.getMname() + " "+ name.getLname() + " " + age;
	 }	
}

class StudentList {
	 public static Student[] list = new Student[10]; // list of students	 
	 public static int count = 0; // count of students added in the list
	 
	 public static void addStudent(Student std) {
		 if(count>= 20) 
			 return; // if count is already 20 or more then return
		 list[count] = std;
		 count++;
	 }
	 
	 public static Student[] getStudentsWithAge(int age) {
		 int j=0;
		 Student s[]=new Student[count];
		 for(int i=0;i<count;i++){
			 if(list[i].getAge()==age){
				 s[j++]=list[i];				 				 
			 }
		 }
		 if(j==0){
			 return null;
		 }
		 else{
			 return s;
		 }
	 }
	 
	 public static Student[] getStudentsWithLastName(String lastName) {
		 int j=0;
		 Student s[]=new Student[count];
		 for(int i=0;i<count;i++){
			 if(list[i].getName().getLname().equals(lastName)){
				 s[j++]=list[i];				 				 
			 }
		 }
		 if(j==0){
			 return null;
		 }
		 else{
			 return s;
		 }
	 }
	 
	 public static Student[] getStudentsInRange(int minAge, int maxAge) {
		 int j=0;
		 Student s[]=new Student[count];
		 for(int i=0;i<count;i++){
			 if(list[i].getAge()>=minAge && list[i].getAge()<=maxAge){
				 s[j++]=list[i];				 				 
			 }
		 }
		 if(j==0){
			 return null;
		 }
		 else{
			 return s;
		 }
	 }
}



class Test{	
	public static Student readStudent() throws IOException{		
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter Student First Name");
		String first_name=in.nextLine();
		System.out.println("Enter Student Middle Name");
		String middle_name=in.nextLine();
		System.out.println("Enter Student Last Name");
		String last_name=in.nextLine();
		System.out.println("Enter Student Name Format");
		int x = in.nextInt();
		System.out.println("Enter Student Age");
		int age = in.nextInt();
		
		String NAME=null;
		
		if(x==1){
			 NAME = first_name + "," + middle_name + "," + last_name;			
		}
		else{
			 NAME = last_name + ";" + middle_name + ";" + first_name;	
		}
		
		Name n= new Name(NAME);
		Student s = new Student(n,age);
		return s;
		
		/* This method reads the student details and returns the Student instance.
		Values to be read from System.in are:
		1. First name of Student, 2. Middle name of student, 3. Last name of
		 Student, 4. Name format (1 for comma(,) separated and 2 for semicolon
		separated), 5. age of student
		*/
	} 
	
	
	public static void main(String args[]) throws IOException{
		
		Student s;
		
		for(int i=0;i<5;i++){
			s = readStudent();
			StudentList.addStudent(s);
		}
		/* 1. Write java code for reading details of 10 students and add them
		in the static list of StudentList class.*/
		
		
		Student list1[]=StudentList.getStudentsWithAge(20);
		for(int i=0;i<list1.length;i++){
			if(list1[i]!=null){
				System.out.println(list1[i]);
			}	
			else{
				break;
			}
		}
		/* 2. Write java code for displaying the all the students with age 20 from
		static list field of StudentList class*/
		
		
		Student list2[]=StudentList.getStudentsWithLastName("Sharma");
		for(int i=0;i<list2.length;i++){
			if(list2[i]!=null){
				System.out.println(list2[i]);
			}	
			else{
				break;
			}
		}
		/* 3. Write java code for displaying the student details for all students
		having last name “Sharma” from static list of StudentList class */
		
		
		Student list3[]=StudentList.getStudentsInRange(16,20);
		for(int i=0;i<list3.length;i++){
			if(list3[i]!=null){
				System.out.println(list3[i]);
			}	
			else{
				break;
			}
		}
		/* 4. Write java code for displaying all the students whose age falls in
		the range minAge = 16 and maxAge = 20 from static list of StudentList
		class*/
		
		
	}// End of main() Method
}